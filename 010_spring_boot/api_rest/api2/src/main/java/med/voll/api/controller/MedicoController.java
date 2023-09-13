package med.voll.api.controller;

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
public class MedicoController {

    /* No es recomendable usar @Autowired a nivel de declaración pues genera
     problemas al realizar pruebas unitarias */
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(
                                                           @RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
                medico, new DatosDireccion(medico.getDireccion())
        );

        //DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
        //        medico.getId(), medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getDocumento(),
        //        new DatosDireccion(
        //                medico.getDireccion().getCalle(), medico.getDireccion().getDistrito(), medico.getDireccion().getCiudad(),
        //                medico.getDireccion().getNumero(), medico.getDireccion().getComplemento()
        //        )
        //);
        URI url = uriComponentsBuilder.path("/medicos/{id}") .buildAndExpand(medico.getId()).toUri();
        return  ResponseEntity.created(url).body(datosRespuestaMedico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoMedicos>> listadoMedicos(
            @PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedicos::new));
    }

    @PutMapping
    @Transactional
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
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaMedico> retornaDatosMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        DatosRespuestaMedico  datosRespuestaMedico = new DatosRespuestaMedico(
                medico, new DatosDireccion(medico.getDireccion())
        );
        return ResponseEntity.ok(datosRespuestaMedico);
    }

}
