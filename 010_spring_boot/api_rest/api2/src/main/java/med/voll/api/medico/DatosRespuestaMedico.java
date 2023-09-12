package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

public record DatosRespuestaMedico(@NotNull Long id, String nombre,
                                                                        String email, String telefono, String documento,
                                                                        DatosDireccion direccion) {
}
