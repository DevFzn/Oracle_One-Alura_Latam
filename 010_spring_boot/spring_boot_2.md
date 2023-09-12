# API Rest Java - Buenas prácticas y protección

Continuación de [Desarrollo de una API Rest](./spring_boot_1.md) donde se vio:

- Creación de un API Rest
- Crud (Create, Read, Update, Delete)
- Validaciones
- Paginación y orden

### Objetivos

- Buenas prácticas al desarrollar un API
- Tratamiento de errores
- Autenticación y Autorización
- Tokens JWT

## Buenas prácticas

Se modifican las respuestas de la API

[DatosRespuestaMedico](./api_rest/api2/src/main/java/med/voll/api/medico/DatosRespuestaMedico.java)

```java
public record DatosRespuestaMedico(
                        @NotNull Long id, String nombre,
                        String email, String telefono, String documento,
                        DatosDireccion direccion) {}
```

[MedicoController](./api_rest/api2/src/main/java/med/voll/api/controller/MedicoController.java)

```java
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(
                @RequestBody @Valid DatosRegistroMedico datosRegistroMedico,
                UriComponentsBuilder uriComponentsBuilder) {
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        DatosRespuestaMedico datosRespuestaMedico = new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()
                )
        );
        URI url = uriComponentsBuilder.path("/medicos/{id}")
                    .buildAndExpand(medico.getId()).toUri();
        return  ResponseEntity.created(url).body(datosRespuestaMedico);
    }

    @GetMapping
    public Page<DatosListadoMedicos> listadoMedicos(@PageableDefault(size = 5)
                Pageable paginacion) {
        return medicoRepository.findByActivoTrue(paginacion)
                .map(DatosListadoMedicos::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico
        datosActualizarMedico) {
        Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
        medico.actualizarDatos(datosActualizarMedico);
        return ResponseEntity.ok(
            new DatosRespuestaMedico(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getTelefono(),
                medico.getDocumento(),
                new DatosDireccion(
                        medico.getDireccion().getCalle(),
                        medico.getDireccion().getDistrito(),
                        medico.getDireccion().getCiudad(),
                        medico.getDireccion().getNumero(),
                        medico.getDireccion().getComplemento()
                )
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }
}
```

## Codigos de respuesta del protocolo HTTP

El protocolo HTTP (***Hypertext Transfer Protocol***, *RFC 2616*) es el protocolo
encargado de realizar la comunicación entre el cliente, que suele ser un
navegador, y el servidor. De esta forma, para cada *solicitud* realizada por el
cliente, el servidor responde si tuvo éxito o no. Si no tiene éxito, la mayoría
de las veces, la respuesta del servidor será una secuencia numérica acompañada
de un mensaje.

Categoría de código
Los códigos **HTTP** (o **HTTPS**) tienen tres dígitos, y el primer dígito
representa la clasificación dentro de las cinco categorías posibles.

- **`1XX` Informativo:** la solicitud fue aceptada o el proceso aún está en curso
- **`2XX` Confirmación:** la acción se completó o se comprendió
- **`3XX` Redirección:** indica que se debe hacer o se debió hacer algo más para
completar la solicitud
- **`4XX` Error del cliente:** indica que la solicitud no se puede completar o
contiene una sintaxis incorrecta
- **`5XX` Error del servidor:** el servidor falló al concluir la solicitud.

### Principales códigos de error

Estos permiten comprender mejor la comunicación de su navegador con el servidor
de la aplicación que se intenta acceder.

#### Error 403

El código 403 es el error **"Prohibido"**. Significa que el servidor entendió
la solicitud del cliente, pero se niega a procesarla, ya que el cliente no está
autorizado para hacerlo.

#### Error 404

Mensaje de Error 404, significa que la URL no lo llevó a ninguna parte.
Puede ser que la aplicación ya no exista, que la URL haya cambiado o que haya
ingresado una URL incorrecta.

#### Error 500

Es un error menos común, pero aparece de vez en cuando. Este error significa que
hay un problema con una de las bases que hace que se ejecute una aplicación.
Básicamente, este error puede estar en el servidor que mantiene la aplicación
en línea o en la comunicación con el sistema de archivos, que proporciona la
infraestructura para la aplicación.

#### Error 503

El error 503 significa que el servicio al que se accede no está disponible
temporalmente. Las causas comunes son un servidor que está fuera de servicio
por mantenimiento o sobrecargado. Los ataques maliciosos como ***DDoS***
causan mucho este problema.


Para consultar sobre algún código HTTP, se puede usar la sgte. página:

[http cat](https://http.cat)

ejm consulta por código `405 Method Not Allowed`

```http
https://http.cat/405
```

