# Formación programación

## Primeros pasos

### 04 Crea tus primeras paginas HTML5 y CSS

#### Parte 1 Mi primera página web

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

##### Sistema hexadecimal

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

##### Equipo de Front End

- Programador Front End
- Responsable por UX (user experiencie)
- Responsable por UI (user interface)
- Copywriter (Generador de Contenido)
- SEO (Search Engine Optimization)

Final curso HTML5 y CSS parte 1 - Página
[barbería](./html_css_parte1/index.html) -
estilo.[css](./html_css_parte1/style.css).

#### Parte 2 - Posicionamiento, listas y navegación

Página [productos](./html_css_parte2/productos.html) y
[estilo](./html_css_parte2/productos.css).

- Base de un archivo HTML.
- Lista html no ordenada.
- Posicionamiento listas y 'menu' de navegación.
- Posicionamiento encabezado de página.

**CSS** - La propiedad [display](https://www.w3schools.com/css/css_inline-block.asp).

<details><summary markdown="span">estilo</summary>

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

</details></br>

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
en [productos.css](./html_css_parte2/productos.css). Se utiliza una imagen como
fondo con la propiedad css background `background: url(./imagenes/bg.jpg)` para
la etiqueta `<footer>`.

[Centrar](https://www.aluracursos.com/blog/centrar-un-elemento-con-css) un
elemento con css.

Caracteres especiales, unicode
[wiki](https://en.wikipedia.org/wiki/List_of_Unicode_characters).

Final curso HTML5 y CSS parte 2

