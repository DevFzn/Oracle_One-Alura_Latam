const area_mensaje = document.getElementById("frase");
const area_info = document.getElementById("resultado");
const boton_encrip = document.getElementById("btn-encriptar");
const boton_desencrip = document.getElementById("btn-desencriptar");
const boton_copiar = document.getElementById("btn-copiar");

var dict = { "e" : "enter", "i" : "imes", "a" : "ai", "o" : "ober", "u" : "ufat" };
var largo_dict = Object.keys(dict).length;

function imprimir(frase){
    document.write(frase+"<br>");
}

function encriptar(){
    let frase = area_mensaje.value;
    if (frase != ""){
        let arr_frase = Array.from(frase);
        let resultado = []
        for (let index=0; index < arr_frase.length; index++) {
            let letra = arr_frase[index];
            if (dict[letra] !== undefined) {
                resultado += dict[letra];
            } else {
                resultado += letra;
            }
        }
        area_info.innerHTML = resultado;
        area_mensaje.value = "";
        area_mensaje.focus();
    }
}

function desencriptar(){
    let frase = area_mensaje.value;
    if (frase != ""){
        for (let key in dict) {
            let busca = dict[key];
            frase = frase.replaceAll(busca,key);
        }
        area_info.innerHTML = frase;
        area_mensaje.value = "";
        area_mensaje.focus();
    }
}

function copiar_texto(){
    let frase = area_info.value;
    if (frase != ""){
        navigator.clipboard.writeText(frase);
    }
    area_mensaje.focus();
}

boton_encrip.addEventListener("click", encriptar);
boton_desencrip.addEventListener("click", desencriptar);
boton_copiar.addEventListener("click", copiar_texto);
