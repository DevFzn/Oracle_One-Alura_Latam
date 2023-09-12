package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.paciente.*;
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
                    paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumento(),
                    new DatosDireccion(
                            paciente.getDireccion().getCalle(), paciente.getDireccion().getDistrito(), paciente.getDireccion().getCiudad(),
                            paciente.getDireccion().getNumero(), paciente.getDireccion().getComplemento()
                    )
            );
            URI url = uriComponentsBuilder.path("/pacientes/{id}") .buildAndExpand(paciente.getId()).toUri();
            return  ResponseEntity.created(url).body(datosRespuestaPaciente);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoPacientes>> listadoPacientes(@PageableDefault(size = 5) Pageable paginacion) {
        //return pacienteRepository.findAll(paginacion).map(DatosListadoPacientes::new);
        return ResponseEntity.ok(pacienteRepository.findByActivoTrue(paginacion).map(DatosListadoPacientes::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaPaciente> actualizarPaciente(@RequestBody @Valid DatosActualizarPaciente datosActualizarPaciente) {
        Paciente paciente = pacienteRepository.getReferenceById(datosActualizarPaciente.id());
        paciente.actualizarDatos(datosActualizarPaciente);
        return ResponseEntity.ok(new DatosRespuestaPaciente(
                paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumento(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(), paciente.getDireccion().getDistrito(),
                        paciente.getDireccion().getCiudad(),paciente.getDireccion().getNumero(),
                        paciente.getDireccion().getComplemento()
                )
        ));
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
        var datosPaciente = new DatosRespuestaPaciente(
                paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getTelefono(), paciente.getDocumento(),
                new DatosDireccion(
                        paciente.getDireccion().getCalle(), paciente.getDireccion().getDistrito(), paciente.getDireccion().getCiudad(),
                        paciente.getDireccion().getNumero(), paciente.getDireccion().getComplemento()
                )
        );
        return ResponseEntity.ok(datosPaciente);
    }

}
