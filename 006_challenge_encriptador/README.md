# Challenge Encriptador

¿Qué son los Alura Challenges?

Es una forma de implementar el Challenge Based Learning, es decir, aprendizaje
basado en desafíos que Apple ayudó a crear. Por medio de estos podrás desafiarte
a resolver un problema real.

## Challenge One

- [link](https://www.aluracursos.com/challenges/challenge-one-logica)
- [video](https://youtu.be/BLgio_oPkLw)

El Challenge ONE: Principiante en programación, fue ideado para que coloques en
práctica los conocimientos que vas adquiriendo mientras realizas los cursos de
la ruta de aprendizaje.

El desafío está dividido en Sprint

[Sprint 01](https://www.aluracursos.com/challenges/challenge-one-logica/sprint01-construye-un-encriptador-texto-con-javascript)

```txt
Construye un encriptador de texto con Javascript La Sprint tiene
una duración de 6 semanas, este es el tiempo sugerido para la realización de
este desafío y durante este periodo contarás con Live de Mentoría donde nuestros
instructores resolverán en vivo las dudas referentes al Challenge.

La realización del Challenge es una forma de demostrar lo que has aprendido y
finalmente, podrás publicar tus proyectos, e ir construyendo tu portafolio.

Todo esto mientras comentas y ayudas en proyectos de otros colegas del programa ONE.
```

Links Necesarios/Utiles:

- [Trello](https://trello.com/b/WTdfcewC/encriptador-de-texto-alura-challenges-oracle-one)
Board.
- [Discord](https://discord.gg/2E5mQEat)
- Modelo [Figma](https://www.figma.com/file/trP3p5nEh7XUyB3n2bomjP/Alura-Challenge---Desaf%C3%ADo-1---L%C3%B3gica)
- Figma en el desarrollo [Front End](https://youtu.be/UuAX5azcvDQ)


### Instrucciones

Crear una aplicación que encripta textos, así podrás intercambiar mensajes
secretos con otras personas que sepan el secreto de la encriptación utilizada.

Las "llaves" de encriptación que utilizaremos son las siguientes:

| Letra | Codificación |
| - | - |
| `e` | `enter` |
| `i` | `imes` |
| `a` | `ai` |
| `o` | `ober` |
| `u` | `ufat` |

Requisitos:

- Debe funcionar solo con letras minúsculas.
- No deben ser utilizados letras con acentos ni caracteres especiales.
- Debe ser posible convertir una palabra para la versión encriptada también
devolver una palabra encriptada para su versión original.

Por ejemplo:

```txt
gato     --> gaitober
gaitober --> gato
```

La página debe tener campos para inserción del texto que será encriptado o
desencriptado, y el usuario debe poder escoger entre as dos opciones.

El resultado debe ser mostrado en la pantalla.

Extras:

- Un botón que copie el texto **encriptado/desencriptado** para la sección de
transferencia, es decir, que tenga la misma funcionalidad del `Ctrl`+`C` o de
la opción `copiar` del menú de las aplicaciones.
- Cuatro semanas para desarrollar el proyecto, trabajando con el sistema ágil
de desarrollo, utilizando el **Trello** de la siguiente forma:
    - La columna **Listos** para iniciar presenta las tarjetas con elementos que
    aun no fueron desarrollados.
    - En la columna **En Desarrollo** estarán los elementos que estés desarrollando
    en el momento. Al iniciar una tarea, podrás mover la tarjeta que contiene
    dicha tarea para esta columna.
    - En la columna **Pausado** estarán los elementos que comenzaste a desarrollar,
    pero necesitaste parar por algún motivo.
    - Por fin, en la columna **Concluido** estarán los elementos ya concluidos.
- Pie de página con iformación/links del creador.

### Modelo Figma

![img](./html/imagenes/modelo_figma.png)

#### Desencripta el mensaje secreto

```txt
fenterlimescimesdaidenters poberr enternfrenterntair enterstenter
dentersaifimesober y haibenterrlober cobernclufatimesdober cobern enterximestober!
```

<details><summary markdown="span">ver mensaje desencriptado</summary>

```txt
felicidades por enfrentar este
desafio y haberlo concluido con exito!
```

</details>

## Proyecto

- [Javascript](./html/encriptador.js)
- [Home](./html/index.html)
- [Estilo](./html/style.css)
- [Repositorio](https://github.com/DevFzn/Oracle_One-Alura_Latam/tree/master/006_challenge_encriptador/README.md)
- [Sitio](https://github.com...)

### Sitio web

Lista de tareas challenge encriptador

- [x] Github
    - [x] Crear repositorio en GitHub y trabajar con control de versiones.
- [x] Título de su sitio web
- [x] Campo para el texto que va a ser encriptado/desencriptado
- [x] Un botón para encriptar y otro para desencriptar
    - [x] Crear función
        - [x] Desarrollar la lógica de encriptación
        - [x] Desarrollar la lógica de desencriptación
    - [x] Conectar función a su respectivo botón en el HTML
    - [x] Capturar el texto escrito en el campo del input del HTML
- [ ] Área para mostrar el texto encriptado/desencriptado dinámica:
    - [x] Área para mostrar el texto encriptado/desencriptado
    - [ ] Ocultar y mostrar diferentes elementos dependiendo del estado, comenzando
    con una imagen que debe ser substituida por el texto encriptado/desencriptado
- [ ] Trabajar estilos

#### Recursos

- Modelo en
[Figma](https://www.figma.com/file/trP3p5nEh7XUyB3n2bomjP/Alura-Challenge---Desaf%C3%ADo-1---L%C3%B3gica)
- HTML - [input](https://developer.mozilla.org/es/docs/Web/HTML/Element/input)
- HTML - [textarea](https://developer.mozilla.org/es/docs/Web/HTML/Element/textarea)
- Imagen [input](./html/imagenes/input.png) trello.
- HTML - DOM [Style display](https://www.w3schools.com/jsref/prop_style_display.asp)
Property
- Imagen [1](./html/imagenes/1.png) area de texto desencriptado
- Imagen [2](./html/imagenes/2.png) area de texto desencriptado
- Imagen boton [encriptar](./html/imagenes/boton-enc.png)
- Imagen boton [desencriptar](./html/imagenes/)
- Interact with the [clipboard](https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions/Interact_with_the_clipboard)
- [Clipboard](https://developer.mozilla.org/en-US/docs/Web/API/Clipboard_API) API
- Configuración de [Git](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Configurando-Git-por-primera-vez)
- Subir proyecto a [GitHub](https://www.youtube.com/watch?v=bhKkeOMysuw)
- Crear Github [page](https://developer.mozilla.org/es/docs/Learn/Common_questions/Tools_and_setup/Using_Github_pages)

## Entrega

Checklist para entrega del proyecto

- [ ] Publica en GitHub Pages
- [ ] Agregar el #challengeonecodificador5 en Github
- [ ] Rellenar formulario de
[envío](https://lp.alura.com.br/alura-latam-entrega-challenge-one-esp) con el
enlace a la GitHub Page del proyecto
- [ ] Revisar e-mail y obtén tu Badge
- [ ] Publica un video y/o tu proyecto en Linkedin
