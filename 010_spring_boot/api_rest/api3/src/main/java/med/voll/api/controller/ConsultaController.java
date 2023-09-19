package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultaService;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosCancelarConsulta;
import med.voll.api.domain.consulta.DatosDetalleConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional // ojo de donde se importa esta anotación
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) {
        System.out.println(datos);
        var response = service.agendar(datos);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleConsulta>> listar(
                @PageableDefault(size = 10, sort = {"fecha"}) Pageable paginacion) {
        var response = service.consultar(paginacion);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DatosCancelarConsulta dados) {
        service.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
