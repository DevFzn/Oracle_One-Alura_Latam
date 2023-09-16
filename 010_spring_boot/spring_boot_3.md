# API Rest Java - Documentar, Probar y Preparar una API para su Implementación

Continuación de
[Buenas Prácticas y Protección de una API Rest](./spring_boot_2.md) donde se
vio:

- Creación de un API Rest
- Crud (Create, Read, Update, Delete)
- Validaciones
- Paginación y orden
- Buenas prácticas REST
- Tratamiento de errores
- Control de acceso con JWT

### Objetivos

- Funcionalidad agendar consultas
- Documentación de la API
- Tests Automatizados
- Build del proyecto

[trello](https://trello.com/b/NiWWC55L/vollmed-api-3ra-parte) -
[figma](https://www.figma.com/file/tWpylp7pB4n8rX1AsKTsY2/Voll_med-FRONT-Mobile)


## Nuevas Funcionalidades

- Controller
- DTOs
- Entidades JPA
- Repository
- Migration
- Security
- Reglas de negocio

Proyecto [Voll_Med API](./api_rest/api3/)

Para implementar esta u otras funcionalidades, siempre es necesario crear los
siguientes tipos de códigos:

- **Controller**(s), para mapear la solicitud de la nueva funcionalidad
- **DTO**s, que representan los datos que llegan y salen de la API
- **Entidad**(es) **JPA**
- **Repository**(s), para aislar el acceso a la base de datos
- **Migration**, para hacer las alteraciones en la base de datos

Estos son los cinco tipos de código que **siempre** se desarrollan para una nueva
funcionalidad. Esto también se aplica al agendamiento de las consultas,
incluyendo un sexto elemento a la lista, ***las reglas de negocio***.
En este proyecto, se implementan las reglas de negocio con algoritmos más
complejos.

### Implementando la funcionalidad

Se desarrolla la funcionalidad por partes. Empezaremos por los primeros cinco
elementos de la lista, que son más básicos. Luego, la parte de reglas de negocio.

Se crea un nuevo `ConsultaController` en el paquete
[`src.main.java.med.voll.api.controller`](./api_rest/api2/src/main/java/med/voll/api/controller).

La idea es tener un **Controller** para recibir esas solicitudes relacionadas con
el agendado de consultas.

Es una clase Controller, con las ***anotaciones*** de Spring `@Controller`,
`@ResponseBody`, `@RequestMapping("consultas")` o `@RestController`. Mapea las
solicitudes que llegan con la **URI** `/consultas`, que debe llamar a este
controller y no a los otros.

Luego, el método anotado con `@PostMapping`. Entonces, la solicitud para programar
una consulta será del tipo **POST**, como en otras funcionalidades.

[ConsultaController](./api_rest/api3/src/main/java/med/voll/api/controller/ConsultaController.java)

```java
@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(
                @RequestBody @Valid DatosAgendarConsulta datos) {
        System.out.println(datos);
        service.agendar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }
}
```

[DatosAgendarConsulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/DatosAgendarConsulta.java)
se trata de un registro similar a los que visto anteriormente. Tiene los campos
que provienen de la API (`Long idMedico`, `Long idPaciente` y
`LocalDateTime fecha`) y las anotaciones de **BEAN validation** `@NotNull` para el
`Id` del paciente y para la `fecha`, además de que la fecha debe ser en el
**futuro** (`@Future`), es decir, no se podrá programar una consulta en días
pasados.

```java
@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) {
        System.out.println(datos);
        service.agendar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }
}
```

Al volver al Controller, el otro DTO es el de respuesta, llamado
`DatosDetalleConsulta`. Devuelve el `ID` de la consulta creada, del **médico**,
del **paciente** y la **fecha de la consulta** registrada en el sistema.

En el paquete `src.main.java.med.voll.api.domain`, se crea el subpaquete
`consulta`, que abarca las clases relacionadas con el dominio de consulta.

Entre ellas, la ***entidad JPA***
[Consulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/Consulta.java),
que contiene las anotaciones de ***JPA*** y ***Lombok***, así como la
información de la consulta: `medico`, `paciente` y `fecha`.

```java
@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime fecha;

}
```

En este caso, `medico` y `paciente` son relaciones con las otras entidades
`Medico` y `Paciente`.

También se crea
[ConsultaRepository](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/ConsultaRepository.java),
que está vacío por el momento.

```java
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {}
```

Por último, la migración número 6 (`V6`) en
`src.main.java.med.voll.api.resources.db.migration`, que crea la tabla de
consultas.

```sql
CREATE TABLE consultas(

    id BIGINT NOT NULL AUTO_INCREMENT,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    fecha DATETIME NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY(medico_id)
    REFERENCES medicos(id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY(paciente_id)
    REFERENCES pacientes(id)

);
```

Los campos de `Id` de **consulta**, `Id` de **paciente**, `Id` de **médico** y
`fecha`, donde `medico_id` y `paciente_id` son ***claves foráneas*** que apuntan
a las tablas `medicos` y `pacientes`.

Estos son los códigos estándar para cualquier funcionalidad, con sus respectivos
cambios de acuerdo con el proyecto. Cada uno creará un controlador o una entidad
distinta, pero el funcionamiento es el mismo.

Ahora se puede intentar enviar una solicitud a la dirección `/consultas` y
verificar si se redirige al `ConsultaController` y comprobando el `System.out`
que muestra los datos que llegaron en el JSON de la solicitud.

```json
{
    "idPaciente": 1,
    "idMedico": 1,
    "fecha": "2023-09-14T10:00"
}
```

Esta es la ipmplementación del esqueleto de la funcionalidad. Ahora se deben
implementar las reglas de negocio.

El trabajo es un poco diferente a lo ya realizado con la validación de campos
de formulario vía ***BEAN validation***. Estas validaciones son más complejas.

***¿Cómo implementarlas?***

Observando `ConsultaController.java`, se podrían hacer todas las validaciones
en el método `agendar()`, antes del retorno. Sin embargo, esa no es una buena
práctica.

La clase controller no debe traer las reglas de negocio de la aplicación.
Es solo una clase que controla el flujo de ejecución: cuando llega una solicitud,
llama a la clase X, devuelve la respuesta Y. Si la condición es Z, devuelve otra
respuesta y así sucesivamente. Es decir, solo controla el flujo de ejecución y,
por lo tanto, no debería tener reglas de negocio.

Así, aislando las reglas de negocio, los algoritmos, los cálculos y las
validaciones en otra clase que será llamada por el Controller.

En el paquete `consulta`. Se creas la clase para contener las reglas de agendado
de consultas llamada
[AgendaDeConsultasService](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/AgendaDeConsultaService.java).

El nombre es muy autoexplicativo, esta clase contendrá la agenda de consultas.
Se pueden tener otras funcionalidades en esta clase, relacionadas con el
agendamiento de consultas.

Esta no es una clase ***Controller*** ni una clase de ***configuraciones***. Esta
clase representa un servicio de la aplicación, el de agendado de consultas. Por
lo tanto, será una ***clase de servicios*** (**Service**) y llevará la anotación
`@Service`. El objetivo de esta anotación es declarar el componente de servicio
a Spring Boot.

Dentro de esta clase, se crear un método `public void agendar()`, que recibe
como parámetro el **DTO** `DatosAgendarConsulta`.

```java
@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DatosAgendarConsulta datos) {

        if (pacienteRepository.findById(datos.idPaciente()).isPresent()) {
            throw  new ValidacionDeIntegridad("Id de paciente no encontrado");
        }
        if (datos.idMedico() != null && medicoRepository.existsById(datos.idMedico())) {
            throw  new ValidacionDeIntegridad("Id de médico no encontrado");
        }

        var paciente = pacienteRepository.findById(datos.idPaciente()).get();
        var medico = medicoRepository.findById(datos.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, datos.fecha());
        consultaRepository.save(consulta);
    }
}
```

La clase Service ejecuta las reglas de negocio y las validaciones de la aplicación.

Esta clase se utliza en `ConsultaController`, con `@Autowired` se comuníca a
Spring que instancie este objeto

Con esto, se inyecta la clase `AgendaDeConsultas` en el Controller. En el método
`agendar` del `Controller`, se obtiene el objeto `agenda` y se llama al método
`agendar()`, pasando como parámetro los datos que llegan al `Controller`.
Todo esto antes del retorno.

El **Controller** recibe la información, hace solo la validación de
***BIN validation*** y llama a la clase **Service** `AgendaDeConsultas`, que
ejecutará las reglas de negocio. Esta es la forma correcta de manejar las reglas
de negocio.

En la clase `AgendaDeConsultas` y están todas las validaciones para el método
`agendar()`.

El requerimiento especifica que se debe recibir la solicitud con los datos de
agendamiento y se deben guardar en la tabla de consultas.

Por lo tanto, se necesita acceder a la base de datos y a la tabla de consultas
en esta clase. Así que se declara un atributo `ConsultaRepository`, llamándolo
`consultaRepository`.

Se usa la anotación `@Autowired` para que el Spring Boot inyecte este repository
en la clase `Service`.

Al final del método `agendar()`, se inserta `consultaRepository.save()` pasandole
un objeto del tipo consulta, la entidad **JPA**. Obviamente, solo se puede llamar
a este método si todas las validaciones se han ejecutado de acuerdo con las
reglas de negocio.

La entidad `Consulta` está anotada con `@AllArgsConstructor` de ***Lombok***,
que genera un constructor con todos los atributos. Se puede usar este mismo
constructor en `AgendamientoDeConsultas`.
El primer parámetro es el `Id null`, ya que es la base de datos la que pasará
el `Id`. El segundo es `medico`, `paciente` y `fecha`. Esta última viene en el
**DTO**, a través del parámetro `datos`.

Sucede que el médico y el paciente no llegan en la solicitud, sino el `Id` del
médico y el `Id` del paciente. Por lo tanto, es necesario establecer el objeto
completo en la entidad y no solo el `Id`.

Por lo tanto, es necesario cargar médico y paciente desde la base de datos.
Se necesita inyectar, entonces, dos Repositories más en `Service`:
`MedicoRepository` y `PacienteRepository`.

En el método `agendar()`, se crea un objeto paciente también. Usando
`pacienteRepository.findById()` para buscar el objeto por `Id`, que está dentro
del DTO datos.

En la solicitud solo viene el `Id`, pero se necesita cargar el objeto completo.
Por lo tanto, se usa el Repository para cargar por el `Id` de la base de datos.
El médico seguirá la misma dinámica (
[AgendaDeConsultasService](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/AgendaDeConsultaService.java)
).

Aparecerá un error de compilación porque el método `findById()` no devuelve la
entidad, sino un Optional. Por lo tanto, al final de la línea, antes del punto
y coma, es necesario incluir `.get()` junto a `findById()`. Esto hace que tome
la entidad cargada.

El método `agendar()` en la clase `Service` obteniene el `Id`, cargar el paciente
y el médico desde la base de datos creando una entidad consulta pasando el médico,
el paciente y la fecha que viene en el DTO, y se guarda en la base de datos.

Pero antes de esto, se necesita escribir el código para realizar todas las
validaciones que forman parte de las reglas de negocio.

A continuación, se aborda cómo realizar las validaciones de la mejor manera
posible.

### Validaciones

Para verificar el ID del paciente, se usa un `if`. La idea es comprobar si el `Id`
del paciente existe. El Repository es el que consulta la base de datos.

Se puede lanzar una excepción dentro del `if`, que muestre un mensaje indicando
el problema. Incluso se puede crear una excepción personalizada para el proyecto
llamada `ValidacaoException()`. Con un mensaje como
`"El ID del paciente proporcionado no existe"` o similar (
[DatosDetalleConsulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/DatosDetalleConsulta.java)
).

En *package* `med.voll.api.infra.errores` se crea la clase
[ValidacionDeIntegridad](./api_rest/api3/src/main/java/med/voll/api/infra/errores/ValidacionDeIntegridad.java)

```java
package med.voll.api.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String s) {
        super(s);
    }
}
```

En la clase
[AgendaDeConsultasService](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/AgendaDeConsultaService.java),
se realiza la verificación con. Primero, se verifica si existe un paciente con
el `Id` que está llegando a la base de datos. Si no existe, se lanzará una
excepción con un mensaje de error.

Se utiliza el método de la ***interfaz Repository*** en Spring Data llamado
`existsById`. Realiza una consulta a la base de datos para verificar si existe
un registro con un determinado `Id` que devuelve un booleano, `true` si existe,
`false` si no.
Pasando el parámetro `datos.idMedico()`. Se niega la expresión. Con esto, si no
hay un paciente con el `Id` en la base de datos, se debe detener la ejecución
del resto del código.

Recordando la última regla de negocio.

***La elección del médico es opcional, y en ese caso el sistema debe elegir
aleatoriamente algún médico disponible en la fecha/hora indicada.***

Por lo tanto, es posible que un `Id` de médico no llegue en la solicitud.
No se puede llamar a `existsById` si el `Id` del médico es nulo. Esto resultará
en un error para **JPA**.

Solo se puede llamar al `if` si el `Id` no es nulo. Por lo tanto, se agrega una
condición al if antes de la condición actual:

```java
if(datos.idMedico()!=null && !medicoRepository.existsById(datos.idMedico())){
   throw new ValidacionDeIntegridad("Id de medico no encontrado");
}
```

En el caso del médico, al ser un campo opcional, puede ser que la línea
`var medico = medicoRepository.findById(dados.idMedico()).get()` tenga un
`idMedico` nulo.

De acuerdo con la regla de negocio analizada, se necesita escribir un algoritmo
que elija aleatoriamente un médico en la base de datos. Por lo tanto, la línea
anterior necesita ser reemplazada. Pare ello se llama al método privado
`seleccionarMedico(datos)` que recibe un objeto `DatosAgendarConsulta` como
parametro y retorna un objeto `Medico`.

Esto sirve para aislar el algoritmo y evitar que esté suelto dentro del método
de programación de citas. En el método `seleccionarMedico()`, se necesita
verificar si está llegando el `Id` del médico en la solicitud o no.

Si lo está, se obtiene el médico correspondiente de la base de datos. Si no es
así, se debe elegir aleatoriamente un profesional de la salud, según lo indica
la regla de negocio.

Para implementar el algoritmo que elige al médico de manera aleatoria, se deben
cubrir todos los posibles escenarios. La primera comprobación es que si la
persona eligió un médico al hacer la solicitud, usando
`if (dados.idMedico() != null)`.

En este caso, se carga la información de la base de datos con
`return medicoRepository.getReferenceById(dados.idMedico())`. En lugar de usar
`findById()`, se podemos usar `getReferenceById()` y no es necesario llamar al
`.get()` usamdo anteriormente.

También se puedemo cambiar `findById()` por `getReferenceById()` en la variable
paciente, ya que no se quiere cargar el objeto para manipularlo, sino, solo para
asignarlo a otro objeto.

En el método `seleccionarMedico()` , lo primero es verificar si se realiza la
con un médico específico para su atención. Si es así, simplemente se carga la
información del médico que viene de la base de datos.

[DatosAgendarConsulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/DatosAgendarConsulta.java)

```java
public record DatosAgendarConsulta(
        @NotNull Long idPaciente,
        Long idMedico,
        @NotNull @Future LocalDateTime fecha,
        Especialidad especialidad) {
}
```

***¿Cómo elegir un médico aleatorio de la especialidad elegida, disponible en
la fecha y hora seleccionadas?***

Existen varias formas de hacer esto. Se podrían cargar los médicos, filtrarlos por
especialidad y comprobar la fecha de la consulta en Java.

Lo ideal es cargar un profesional aleatorio directamente de la base de datos.
Sin embargo, esta consulta es específica para nuestro proyecto, es decir, no está
lista en Spring Data JPA.

Se necesita crear un método para hacer esto:

```java
return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(
                                datos.especialidad(),datos.fecha()
                            );
```

Creación del método `seleccionarMedicoConEspecialidadEnFecha(especialidad, fecha)`
en
[MedicoRepository](./api_rest/api3/src/main/java/med/voll/api/domain/medico/MedicoRepository.java).

Como el nombre del método está en español. No se estam siguiendo el estándar
de nomenclatura, como el `findAllByAtivoTrue()`. De esta manera, Spring Data no
podrá construir el SQL automáticamente. La idea es precisamente esa, para este método,
se escribe el comando SQL manualmente.

Para hacerlo, se usa la anotación `@Query()` justo encima del método. Que viene
del paquete `org.springframework.data.jpa`. Y entre paréntesis, se construye la
consulta utilizando la sintaxis del ***Java Persistence Query Language (JPQL)***.

```java
    @Query("""
            select m from Medico m
                where m.activo= true\s
                and
                m.especialidad=:especialidad\s
                and
                m.id not in( \s
                    select c.medico.id from Consulta c
                    where
                    c.fecha=:fecha
                )
                order by rand()
                limit 1
            """)
    Medico seleccionarMedicoConEspecialidadEnFecha(
                            Especialidad especialidad,
                            LocalDateTime fecha
                        );
}
```

### En resumen
Creación de nuevo *package*
[`domain.consulta`](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/)
donde se crean entidad **Consulta**, clases `ConsultaRepository`,
`DatosAgendarConsulta` y `DatosDetalleConsulta`.

- [Consulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/Consulta.java)
- [ConsultaRepository](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/ConsultaRepository.java)
- [DatosAgendarConsulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/DatosAgendarConsulta.java)
- [DatosDetalleConsulta](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/DatosDetalleConsulta.java)
- [AgendaDeConsultasService](./api_rest/api3/src/main/java/med/voll/api/domain/consulta/AgendaDeConsultaService.java)
- [migración](./api_rest/api3/src/main/resources/db/migration/V6__create-table-consultas.sql)

---

### Anotación @JsonAlias

En caso que uno o mas campos enviados en el formato JSON a la API no correspondan
con los atributos de las clases DTO, se pueden utilizar alias

```java
public record DatosCompra(
            @JsonAlias("producto_id") Long idProducto,
            @JsonAlias("fecha_compra") LocalDate fechaCompra
    ){}
```

La anotación `@JsonAlias` sirve para mapear *alias* alternativos para los campos
que se recibirán del JSON, y es posible asignar múltiples alias:

```java
public record DatosCompra(
            @JsonAlias({"producto_id", "id_producto"}) Long idProducto,
            @JsonAlias({"fecha_compra", "fecha"}) LocalDate fechaCompra
    ){}
```

### Formato fechas

Spring usa un formato definido para las fechas `LocalDateTime`, sin embargo, estas
se pueden personalizar. Por ejemplo, para aceptar el formato `dd/mm/yyy hh:mm`.
Para ello se utiliza la anotación `@JsonFormat`

```java
@NotNull
@Future
@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
LocalDateTime fecha
```

Esta anotación también se puede utilizar en las clases DTO que representan la
información que devuelve la API, para que el JSON devuelto se formatee de
acuerdo con el patrón configurado.
Además, no se limita solo a la clase `LocalDateTime`, sino que también se puede
utilizar en atributos de tipo `LocalDate` y `LocalTime`.

---

### Patrón Service

El ***Service pattern*** es muy utilizado en la programación y su nombre es muy
conocido. Pero a pesar de ser un nombre único, **Service** puede ser interpretado
de varias maneras:

- Puede ser un caso de uso, **Application Service**
- Un **Domain Service**, que tiene reglas de su dominio
- Un **Infrastructure Service**, que utiliza algún paquete externo para realizar
tareas
- etc

A pesar de que la interpretación puede ocurrir de varias formas, la idea detrás
del patrón es separar las reglas de negocio, las reglas de la aplicación y las
reglas de presentación para que puedan ser fácilmente probadas y reutilizadas
en otras partes del sistema.

Existen dos formas más utilizadas para crear **Services**. Puede crear
**Services** más genéricos, responsables de todas las asignaciones de un
**Controller**. O ser aún más específico, aplicando así la S del ***SOLID***:
***Single Responsibility Principle*** (*Principio de Responsabilidad Única*).
Este principio nos dice que una clase/función/archivo debe tener sólo una
única responsabilidad.

Piense en un sistema de ventas, en el que probablemente tendríamos algunas
funciones como:

- Registrar usuario
- Iniciar sesión
- Buscar productos
- Buscar producto por nombre
- etc

Entonces, se podrían crear los siguientes **Services**:

- RegistroDeUsuarioService
- IniciarSesionService
- BusquedaDeProductosService
- etc

Pero es importante estar atentos, ya que muchas veces no es necesario crear un
**Service** y, por lo tanto, agregar otra capa y complejidad innecesarias a
una aplicación. Una regla que podemos utilizar es la siguiente: si no hay reglas
de negocio, simplemente se puede realizar la comunicación directa entre los
controllers y los repositories de la aplicación.

---


