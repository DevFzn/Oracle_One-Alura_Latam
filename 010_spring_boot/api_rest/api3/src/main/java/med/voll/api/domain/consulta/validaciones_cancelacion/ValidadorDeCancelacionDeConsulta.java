package med.voll.api.domain.consulta.validaciones_cancelacion;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosCancelarConsulta;

public interface ValidadorDeCancelacionDeConsulta {
    void validar(DatosCancelarConsulta datos);
}
