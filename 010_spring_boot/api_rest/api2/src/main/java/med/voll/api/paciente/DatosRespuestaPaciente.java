package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

public record DatosRespuestaPaciente(@NotNull Long id, String nombre,
                                     String email, String telefono, String documento,
                                     DatosDireccion direccion) {
}
