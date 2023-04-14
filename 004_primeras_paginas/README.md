# Formación programación

## Primeros pasos

**04** Crea tus primeras paginas HTML5 y CSS

### Parte 1 - Primera página web

Diferencias entre [html y css](https://www.aluracursos.com/blog/html-css-javascript-cuales-son-las-diferencias).

- Descarga archivo [texto-base.txt](./html_css_parte1/texto-base.txt)
(archivo en formato `dos`).

> en NeoVim `set ff=unix`

Página [barbería](./html_css_parte1/index.html) -
estilo.[css](./html_css_parte1/style.css).

Formas de aplicar estilo CSS:

- style inline.

    ```html
        <h1 style="text-align: center;">Sobre la Barbería Alura</h1>
    ```

- style block con tag `<style>`.

    ```html
        <style>
            p {
                text-align: center;
            }
        </style>
    ```

- style [file](./html_css_parte1/style.css).

#### Sistema hexadecimal

Sistema número que consta de las 6 primeras letras del alfabeto y los números
del 0 al 9.

```txt
0 1 2 3 4 5 6 7 8 9 A B C D E F
```

La combinación de estos 16 elementos permiten la representación de mas valores,
en menos caracteres, que por ejemplo, en un sistema binario. Es por esto que es
ampliamente utilizado en el mundo imformático.

La representación de los colores en 6 posiciones

```txt

  0 0 0 0 0 0 <--- Mínimo
  F F F F F F <--- Máximo
# _ _ _ _ _ _
  r r g g b b

  Negro  -> #000000
  Blanco -> #FFFFFF
```

```txt
  0   = Mínimo
  255 = Máximo

  Negro  -> rgb(0,0,0)
  Blanco -> rgb(255,255,255)
```

#### Equipo de Front End

- Programador Front End
- Responsable por UX (user experiencie)
- Responsable por UI (user interface)
- Copywriter (Generador de Contenido)
- SEO (Search Engine Optimization)

Final curso HTML5 y CSS parte 1 - Página
[barbería](./html_css_parte1/index.html) -
estilo.[css](./html_css_parte1/style.css).

### Parte 2 - Posicionamiento, listas y navegación

Página [productos](./html_css_parte2/productos.html) y
[estilo](./html_css_parte2/productos.css).

- Base de un archivo HTML.
- Lista html no ordenada.
- Posicionamiento listas y 'menu' de navegación.
- Posicionamiento encabezado de página.

**CSS** - La propiedad [display](https://www.w3schools.com/css/css_inline-block.asp).

<details><summary markdown="span">css</summary>

```css
    span.a {
        display: inline; /* the default for span */
        width: 100px;
        height: 100px;
        padding: 5px;
        border: 1px solid blue;
        background-color: yellow;
    }

    span.b {
        display: inline-block;
        width: 100px;
        height: 100px;
        padding: 5px;
        border: 1px solid blue;
        background-color: yellow;
    }

    span.c {
        display: block;
        width: 100px;
        height: 100px;
        padding: 5px;
        border: 1px solid blue;
        background-color: yellow;
    }
```

</details>

<details><summary markdown="span">html</summary>

```html
    <body>
        <h1>The display Property</h1>

        <h2>display: inline</h2>
        <div>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum
            consequat scelerisque elit sit amet consequat. Aliquam erat volutpat.
            <span class="a">Aliquam</span> <span class="a">venenatis</span> gravida
            nisl sit amet facilisis. Nullam cursus fermentum velit sed laoreet.
        </div>

        <h2>display: inline-block</h2>
        <div>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum
            consequat scelerisque elit sit amet consequat. Aliquam erat volutpat.
            <span class="b">Aliquam</span> <span class="b">venenatis</span>
            gravida nisl sit amet facilisis. Nullam cursus fermentum velit sed laoreet.
        </div>

        <h2>display: block</h2>
        <div>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum
            consequat scelerisque elit sit amet consequat.Aliquam erat volutpat.
            <span class="c">Aliquam</span> <span class="c">venenatis</span>
            gravida nisl sit amet facilisis. Nullam cursus fermentum velit sed laoreet.
        </div>
    </body>
```

</details></br>

<p align="center">
    <img style="align: center;" width="60%" src="./html_css_parte2/imagenes/css_display_property.png"/>
    <br/><br/>
</p>

En la página [productos](./html_css_parte2/productos.html) se utiliza la
propiedad `display` con el valor `inline-block` para poder ajustar su contenido
en [productos.css](./html_css_parte2/productos.css).

Se utiliza una imagen como fondo con la propiedad css background
`background: url(./imagenes/bg.jpg)` para la etiqueta `<footer>`.

- [Centrar](https://www.aluracursos.com/blog/centrar-un-elemento-con-css) un
elemento con css.
- Caracteres especiales, unicode
[wiki](https://en.wikipedia.org/wiki/List_of_Unicode_characters).

Final curso HTML5 y CSS parte 2

### Parte 3 - Formularios y Tablas

- Nueva página, [contacto.html](./html_css_parte3/contacto.html).
- Se renombraron los estilos css: productos.css como [style.css](./html_css_parte3/style.css),
y style.css como [style_home](./html_css_parte3/style_home.css).
- Creación de formulario HTML, tags `<form>`', `<input>` (text y submit)
para entradas de usuario. Tag `<label>` como etiqueta.
- Conexión del **input** () con su **label**.
- Uso de `id` para el `input` asociado al atributo `for` del `label`.

Jerarquía en css, ejemplo.

```txt
    - Peso gráfico:
       ___________________________
      |                           |   ___________________
      |          inline           |  |                   |   _____________
      |                           |  |         ID        |  |             |   ________
      |                           |  |                   |  |    class    |  |etiqueta|
      |           1000            |  |         100       |  |      10     |  |____1___|
      |                           |  |                   |  |_____________|
      |                           |  |___________________|
      |___________________________|

    - Peso valores:

      form p = 1+1 = 2
      p = 1
      .test = 10
      p.test = 1+10 = 11
      #test = 100
```

<details><summary markdown="span">html</summary>

```html
    ...
    <form>
        ...
        <div>
            <p class="test" id="test">Como prefieres que te contactemos?</p>

            <label for="radio-email"><input type="radio" name="contacto"
            value="email" id="radio-email"> Email</label>

            <label for="radio-telefono"><input type="radio" name="contacto"
            value="telefono" id="radio-telefono"> Teléfono</label>

            <label for="radio-whatsap"><input type="radio" name="contacto"
            value="whatsap" id="radio-whatsap"> Whatsapp</label>
        </div>
        ...
    </form>
    ...
```

</details></br>

<details><summary markdown="span">css</summary>

```css
...

form p { color: blue; }

p { color: red; }

.test { color: yellow; }

p.test { color: magenta; }

#test { color: cyan; }

/* la configuración de estilo inline sobrescribe todo */
```

</details></br>


#### HTML input types

[w3schools input types](https://www.w3schools.com/html/html_form_input_types.asp)

<details><summary markdown="span">tipos</summary>

```html
    <input type="button">
    <input type="checkbox">
    <input type="color">
    <input type="date">
    <input type="datetime-local">
    <input type="email">
    <input type="file">
    <input type="hidden">
    <input type="image">
    <input type="month">
    <input type="number">
    <input type="password">
    <input type="radio">
    <input type="range">
    <input type="reset">
    <input type="search">
    <input type="submit">
    <input type="tel">
    <input type="text">
    <input type="time">
    <input type="url">
    <input type="week">
```

</details></br>

- Etiqueta [fieldset](./html_css_parte3/contacto.html#L40) como agrupador y
[leyend](./html_css_parte3/contacto.html#L41) como parrafo.
- Descripción de imagenes `alt="Descripción de imagen"`.
- Clase css [enviar](./html_css_parte3/style.css#L123) para input submit "Enviar Formulario"
[contacto](./html_css_parte3/contacto.html#L63).
- [Propiedades](./html_css_parte3/style.css#L123): cursor (pointer), transition,
transform (scale, rotate).
- [Tablas](./html_css_parte3/contacto.html#L66) y [estilo](./html_css_parte3/style.css#L142).

Final curso HTML5 y CSS parte 3

### Parte 4 - Avanzando en CSS

- Reestructurando los estilos de [index.html](./html_css_parte4/index.html) para
utilizar [style.css](./html_css_parte4/style.css).
- Utilización de fuentes externas como [google fonts](https://https://fonts.google.com/).

- <details><summary markdown="span">Algunas fuentes de google</summary>

    - [Chakra Petch](https://fonts.google.com/specimen/Chakra+Petch)
    - [Cinzel](https://fonts.google.com/specimen/Cinzel)
    - [Press Start 2P](https://fonts.google.com/specimen/Press+Start+2P)
    - [Luckiest Guy](https://fonts.google.com/specimen/Luckiest+Guy)
    - [Ultra](https://fonts.google.com/specimen/Ultra)
    - [Architects Daughter](https://fonts.google.com/specimen/Architects+Daughter)
    - [Itim](https://fonts.google.com/specimen/Itim)
    - [Phudu](https://fonts.google.com/specimen/Phudu)
    - [Bungee Hairline](https://fonts.google.com/specimen/Bungee+Hairline)
    - [Nosifer](https://fonts.google.com/specimen/Nosifer)
    - [Monserrat](https://fonts.google.com/specimen/Montserrat)
    - [Noto Sans Symbols 2](https://fonts.google.com/noto/specimen/Noto+Sans+Symbols+2)
    - [Noto Music](https://fonts.google.com/noto/specimen/Noto+Music)

</details>

- [Mapa](./html_css_parte4/index.html#L52) incrustado (embedded) y
[estilo](./html_css_parte4/style.css#L239).
- [Video](./html_css_parte4/index.html#L73) incrustado y
[estilo](./html_css_parte4/style.css#L297).

> [CSS Background](https://developer.mozilla.org/en-US/docs/Web/CSS/background) -
developer.mozilla.org.  
> Juegos para [practicar](https://flexboxfroggy.com/)/aprender css.

#### Selectores avanzados CSS

Aplicar estilo solo los hijos directos de `<main>`, ejemplos.

```css
main > p{
    background: red;
}
```

Aplicar estilo solo parrafo que esté despues de una imagen `<img>`.

```css
img + p{
    background: yellow;
}
```

Aplicar estilo a todos los parrafos que estén despues de una imagen `<img>`.

```css
img ~ p{
    background: green;
}
```

Aplicar estilo a todos los parrafos que estén despues de una imagen a excepcion
de aquellos que tengan el id `mision`.

```css
.principal p:not(#mision){
    background: cyan;
}
```

#### Opacidad

- Selector de color RGB: `color: rgb(0,0,0)`
- Selector de color RGB y opacidad: `color: rgba(0,0,0,0.3)`

#### Sombras

- [box-shadow](./html_css_parte4/style.css#L289)
- [text-shadow](./html_css_parte4/style.css#L198)
- Mozilla Box-shadow
[generator](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Backgrounds_and_Borders/Box-shadow_generator)

#### Diseño responsive

Marcar elemento para modificar según resolución de pantalla de hasta 480px
`@media screen and (max-width:480px){ body: red; }`

Diseño [responsive](./html_css_parte4/style.css#L302)

Final curso HTML5 y CSS parte 4

Extra:
[Organizar estudio y portafolio con notion en alura](https://www.aluracursos.com/blog/organizar-estudio-y-portafolio-con-notion-en-alura).

