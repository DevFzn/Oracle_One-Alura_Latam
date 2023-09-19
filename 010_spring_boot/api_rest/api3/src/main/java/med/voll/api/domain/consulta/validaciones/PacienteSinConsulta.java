package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository repositorio;

    public void validar(DatosAgendarConsulta datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);

        var pacienteConConsulta = repositorio.existsByPacienteIdAndFechaBetween(
                                                                                                    datos.idPaciente(),
                                                                                                    primerHorario,
                                                                                                    ultimoHorario);
        if (pacienteConConsulta) {
            throw new ValidationException("No se permite agendar mas de una consulta por día");
        }
    }

}
