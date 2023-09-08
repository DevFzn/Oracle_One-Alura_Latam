# Desarrollo de API Rest Java

### Proyecto

Desarrollo de "clínica médica"

### Objetivos

- Creación de una API Rest
- CRUD (Create, Read, Update, Delete)
- Validaciones
- Paginación y orden

### Tecnologias

- Spring Boot 3
- Java 17
- Lombok
- MySQL/Flyway
- JPA/Hibernate
- Maven
- Insomnia

## Spring initializr

Spring [initializr](https://start.spring.io/)

> Artículo
[cambios principales en versiones](https://www.aluracursos.com/blog/caracteristica-destacables-java8-delante)
de java

### Spring y Spring Boot

Spring es un framework para desarrollar aplicaciones en Java, creado a mediados
de 2002 por *Rod Johnson*, que se ha vuelto muy popular y adoptado en todo el
mundo debido a su simplicidad y facilidad de integración con otras tecnologías.

Se desarrolló de forma modular, en el que cada recurso que proporciona está
representado por un módulo, que se puede agregar a una aplicación según sea
necesario. Con esto, en cada aplicación podemos agregar solo los módulos que
tengan sentido, haciéndola así más liviana. Hay varios módulos en Spring,
cada uno con un propósito diferente, tales como:

- módulo MVC, para desarrollar aplicaciones Web y API's Rest
- módulo de Security, para manejar el control de autenticación y autorización
de las aplicaciones
- módulo Transactions, para gestionar el control transaccional

Sin embargo, uno de los mayores problemas de las aplicaciones que usaban Spring
era la parte de configuración de sus módulos, que se hacía íntegramente con
archivos XML, y después de unos años el framework también comenzó a soportar
configuraciones a través de clases Java, utilizando principalmente anotaciones.
En ambos casos, dependiendo del tamaño y complejidad de la aplicación, así
como de la cantidad de módulos Spring utilizados en ella, dichas configuraciones
eran bastante extensas y difíciles de mantener.

Además, iniciar un nuevo proyecto con Spring era una tarea bastante complicada,
debido a la necesidad de realizar este tipo de configuraciones en el proyecto.

Precisamente para solventar tales dificultades, a mediados de 2014 se creó un
nuevo módulo Spring, denominado ***Boot***, con el objetivo de agilizar la
creación de un proyecto que utilice Spring como framework, así como simplificar
las configuraciones de sus módulos.

El lanzamiento de Spring Boot fue un hito para el desarrollo de aplicaciones
Java, ya que hizo más simple y ágil esta tarea, facilitando mucho la vida de
las personas que utilizan el lenguaje Java para desarrollar sus aplicaciones.

La versión 3 de Spring Boot se lanzó en noviembre de 2022 y algunas de sus
nuevas características principales son:

- Compatibilidad con Java 17
- Migración de especificaciones Java EE a Jakarta EE
- Compatibilidad con imágenes nativas
- Lista completa de las novedades de Spring Boot 3 en:
[Release Notes 3.0](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Release-Notes)

### Creación del proyecto

[.zip](./api_rest/api.zip) Generado con Spring boot initializr

Configuración adicional en IntelliJ IDE para evitar reinicio manual

![img](./imgs/intelli_complr_set.png)
![img](./imgs/intelli_adv_set.png)

Estructura del proyecto [vall_api](./api_rest/api)

```txt
api
├── .idea/
├── .mvn/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── med
│   │   │       └── voll
│   │   │           └── api
│   │   │               ├── controller
│   │   │               │   └── HelloController.java
│   │   │               └── ApiApplication.java
│   │   └── resources/
│   └── test/
├── target/
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```


### Utilizando Insomnia

AppImage de [Insomnia](https://github.com/Kong/insomnia/releases/) para probar API

Test post a `http://127.0.0.1:8080/medicos`, **json**

```json
{
    "nombre": "Rodrigo Lopez",
    "email": "rodrigo.lopez@voll.med",
    "documento": "123456",
    "especialidad": "ortopedia",
    "direccion": {
        "calle": "calle 1",
        "distrito": "distrito 1",
        "ciudad": "Lima",
        "numero": "1",
        "complemento": "a"
    }
}
```

#### JSON

**JSON** (JavaScript Object Notation) es un formato utilizado para representar
información, al igual que **XML** y **CSV**.

Una API necesita recibir y devolver información en algún formato que represente
los recursos que administra. **JSON** es uno de estos posibles formatos, popular
por su ligereza, sencillez, facil lectura (humana y máquina), así como por su
soporte para diferentes lenguajes de programación.

Representación de información en formato **XML**

```xml
<producto>
    <nombre>Mochila</nombre>
    <precio>89.90</precio>
    <descripcion>Mochila para notebooks de hasta 17 pulgadas</descripcion>
</producto>
```

Representación en formato **JSON**

```json
{
    “nombre” : “Mochila”,
    “precio” : 89.90,
    “descripcion” : “Mochila para notebooks de hasta 17 pulgadas”
}
```

Observe cómo el formato JSON es mucho más compacto y legible. Precisamente por eso, se ha convertido en el formato universal utilizado en la comunicación de aplicaciones, especialmente en el caso de las API REST.

Más detalles sobre [JSON](https://www.json.org/json-es.html)

#### CORS

Al desarrollar una API y se busca que sus recursos estén disponibles para
cualquier ***cliente HTTP***.

**CORS** (Cross-Origin Resource Sharing) o “Intercambio de recursos con
diferentes orígenes”. Es común tener errores CORS al consumir y poner a
disposición una API.

![img](./imgs/spring_boot_cors_error.png)

**CORS** es un mecanismo utilizado para agregar encabezados HTTP que indica a
los navegadores permitir que una aplicación web se ejecute en un origen y acceda
a los recursos desde un origen diferente. Este tipo de acción se denomina
***cross-origin HTTP request***.
En la práctica, les informa a los navegadores si se puede acceder o no a un
recurso en particular.

Entendiendo los errores

***`Same-origin policy`***  
Por defecto, una aplicación Front-end, escrita en JavaScript, solo puede acceder
a los recursos ubicados en el mismo origen de la solicitud. Esto sucede debido
a la política del mismo origen (*same-origin policy*), que es un mecanismo de
seguridad de los navegadores que restringe la forma en que un documento o script
de un origen interactúa con los recursos de otro.
Esta política tiene como objetivo detener los ataques maliciosos.

Dos URL comparten el mismo origen si el **protocolo**, el **puerto** (si se
especifica) y el **host** son los mismos. Comparemos posibles variaciones
considerando la URL `https://cursos.alura.com.br/category/programacao`:

| URL | Resultado | Motivo |
| - | - | - |
| `https://cursos.alura.com.br/category/front-end` | Mismo origen | Solo camino diferente |
| `http://cursos.alura.com.br/category/programacao` |Error de CORS | Protocolo diferente (http) |
| `https://faculdade.alura.com.br:80/category/programacao` | Error de CORS | Host diferente |

#### ¿Como consumir una API con una URL diferente sin tener problemas CORS?

Por ejemplo, si se quiere consumir una API que se ejecuta en el puerto `8000` desde
una aplicación React corriendo en el puerto `3000`.

Al enviar una solicitud a una API de origen diferente, la API debe devolver un
header llamado `Access-Control-Allow-Origin`. Dentro de esta, es ella es necesario
informar los diferentes orígenes que serán permitidas de consumir la API, en
este caso: `Access-Control-Allow-Origin: http://localhost:3000`.

Para permitir el acceso desde cualquier origen se utiliza el símbolo `*`:
`Access-Control-Allow-Origin: *`. Esta es una medida **no recomendada**, ya que
permite que fuentes desconocidas accedan al servidor, a menos que sea intencional,
como en el caso de una API pública.

**¿Cómo hacer esto en Spring Boot correctamente?**

#### Habilitando diferentes orígenes en Spring Boot

Configurar el **CORS** para permitir que un origen específico consuma la API,
creando una clase de configuración como la sgte.

```java
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE",
                    "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
```

`http://localhost:3000` sería la dirección de la aplicación Front-end y
`.allowedMethods` los métodos que se permitirán ejecutar. Con esto se podrá
consumir la API sin problemas desde una aplicación front-end.

#### Restricciones o validaciones

|| Médico ||
| :- | :- | :- |
| Nombre | Solo letras | No puede llegar vacío |
| Especialidad | Ortopedia, Ginecología,<br>Cardiología, Pediatria | No puede llegar vacío |
| Documento | Solo números | No puede llegar vacío |
| Email | Formato de email | No puede llegar vacío |
| Teléfono | Solo números | No puede llegar vacío |

|| Dirección ||
| :- | :- | :- |
| Calle | Letras y números | No puede llegar vacío |
| Número | Solo números | No puede llegar vacío |
| Complemento | Letras y números | |
| Cuidad | Letras y números | No puede llegar vacío |

### Java Record

Lanzado oficialmente en Java 16, pero disponible experimentalmente desde Java 14.
**Record** es un recurso que ***permite representar una clase inmutable, que
contiene solo atributos, constructor y métodos de lectura***, de una manera muy
simple y ágil.

Este tipo de clase encaja perfectamente para representar **clases DTO**, ya que
su objetivo es únicamente representar datos que serán recibidos o devueltos por
la API, sin ningún tipo de comportamiento.

Para crear una clase DTO inmutable, sin la utilización de Record, era necesario
escribir mucho código. El sgte. es un ejemplo de una clase DTO que representa
un teléfono:

```java
public final class Telefono {

    private final String ddd;
    private final String numero;

    public Telefono(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Telefono)) {
            return false;
        } else {
            Telefono other = (Telefono) obj;
            return Objects.equals(ddd, other.ddd)
              && Objects.equals(numero, other.numero);
        }
    }

    public String getDdd() {
        return this.ddd;
    }

    public String getNumero() {
        return this.numero;
    }
}
```

Con **Record** todo ese código se puede resumir en una sola línea:

```java
public record Telefono(String ddd, String numero){}
```

Internamente, Java transforma este registro en una clase inmutable, muy similar
al código que se muestra arriba.

Documentación Java
[record](https://docs.oracle.com/en/java/javase/17/language/records.html)

