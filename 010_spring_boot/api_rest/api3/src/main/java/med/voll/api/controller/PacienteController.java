package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.direccion.DatosDireccion;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    /* No es recomendable usar @Autowired a nivel de declaración pues genera
     problemas al realizar pruebas unitarias */
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaPaciente> registrarPaciente(
            @RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente,
            UriComponentsBuilder uriComponentsBuilder) {
            Paciente paciente = pacienteRepository.save(new Paciente(datosRegistroPaciente));
            DatosRespuestaPaciente  datosRespuestaPaciente = new DatosRespuestaPaciente(
                    paciente, new DatosDireccion(paciente.getDireccion())
            );
            URI url = uriComponentsBuilder.path("/pacientes/{id}") .buildAndExpand(paciente.getId()).toUri();
            return  ResponseEntity.created(url).body(datosRespuestaPaciente);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoPacientes>> listadoPacientes(
            @PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(
                pacienteRepository.findByActivoTrue(paginacion).map(DatosListadoPacientes::new)
        );
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaPaciente> actualizarPaciente(
            @RequestBody @Valid DatosActualizarPaciente datosActualizarPaciente) {
        Paciente paciente = pacienteRepository.getReferenceById(datosActualizarPaciente.id());
        paciente.actualizarDatos(datosActualizarPaciente);
        DatosRespuestaPaciente  datosRespuestaPaciente = new DatosRespuestaPaciente(
                paciente, new DatosDireccion(paciente.getDireccion())
        );
        return ResponseEntity.ok(datosRespuestaPaciente);
    }

    // Desactivar Paciente
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.desactivarPaciente();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaPaciente> retornaDatosPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        DatosRespuestaPaciente  datosRespuestaPaciente = new DatosRespuestaPaciente(
                paciente, new DatosDireccion(paciente.getDireccion())
        );
        return ResponseEntity.ok(datosRespuestaPaciente);
    }

}
