package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRespuestaPaciente(@NotNull Long id, String nombre,
                                     String email, String telefono, String documento,
                                     DatosDireccion direccion) {

    public DatosRespuestaPaciente(Paciente paciente, DatosDireccion direccion){
        this(paciente.getId(),
                paciente.getNombre(),
                paciente.getEmail(),
                paciente.getTelefono(),
                paciente.getDocumento(),
                direccion);
    }

}
