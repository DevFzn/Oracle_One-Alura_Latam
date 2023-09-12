package med.voll.api.direccion;

import jakarta.validation.constraints.NotBlank;

public record DatosDireccion(
        @NotBlank String calle,
        @NotBlank String distrito,
        @NotBlank  String ciudad,
        String numero,
        String complemento) {
}
