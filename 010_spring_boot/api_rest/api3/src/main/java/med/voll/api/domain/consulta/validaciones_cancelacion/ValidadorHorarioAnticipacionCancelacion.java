package med.voll.api.domain.consulta.validaciones_cancelacion;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAnticipacion")
public class ValidadorHorarioAnticipacionCancelacion implements ValidadorDeCancelacionDeConsulta {
    @Autowired
    private ConsultaRepository repository;
    @Override
    public void validar(DatosCancelarConsulta datos) {
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEnHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if (diferenciaEnHoras < 24) {
            throw new ValidationException("La consulta solo se puede cancelar con 24 horas de anticipación");
       }
   }

}
