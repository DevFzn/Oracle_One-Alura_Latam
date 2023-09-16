package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank String calle,
        @NotBlank String distrito,
        @NotBlank  String ciudad,
        String numero,
        String complemento) {

    public DatosDireccion(Direccion direccion){
        this(direccion.getCalle(),
                direccion.getDistrito(),
                direccion.getCiudad(),
                direccion.getNumero(),
                direccion.getComplemento()
                );
    }
}
