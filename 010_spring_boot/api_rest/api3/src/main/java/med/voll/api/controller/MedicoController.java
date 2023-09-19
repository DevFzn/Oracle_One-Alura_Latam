package med.voll.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Operation(summary = "Registra un nuevo medico en la base de datos")
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(
                                                           @RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
                medico, new DatosDireccion(medico.getDireccion())
        );
        URI url = uriComponentsBuilder.path("/medicos/{id}") .buildAndExpand(medico.getId()).toUri();
        return  ResponseEntity.created(url).body(datosRespuestaMedico);
    }

    @GetMapping
    @Operation(summary = "Retorna listado de medicos")
    public ResponseEntity<Page<DatosListadoMedicos>> listadoMedicos(
            @PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedicos::new));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Actualiza los datos de un medico existente")
    public ResponseEntity<DatosRespuestaMedico> actualizarMedico(
            @RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
                medico, new DatosDireccion(medico.getDireccion())
        );
        return ResponseEntity.ok(datosRespuestaMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Cambia el estado de un medico a inactivo")
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna los registros del medico según Id")
    public ResponseEntity<DatosRespuestaMedico> retornaDatosMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
                medico, new DatosDireccion(medico.getDireccion())
        );
        return ResponseEntity.ok(datosRespuestaMedico);
    }

}
