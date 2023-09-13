package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(@NotNull Long id, String nombre,
                                                                        String email, String telefono, String documento,
                                                                        DatosDireccion direccion) {

    public DatosRespuestaMedico(Medico medico, DatosDireccion direccion){
        this(medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                direccion);
    }

}
