// Este código hace que cuando presionas un botón, se cargue información de un archivo llamado "json.json" y la muestra en la página web.


"use strict"

// Buscamos el botón con el id "cargar" y le decimos que cuando alguien haga clic en él, llame a la función cargarJSON.
document.getElementById("cargar").addEventListener("click", cargarJSON);

// Esta función se encarga de pedir el archivo "json.json".
function cargarJSON(){
    // Creamos una petición al objeto "XMLHttpRequest" para pedir información.
    let xmlhttp;

    // Aquí preparamos la petición.
    xmlhttp = new XMLHttpRequest();

    // Decimos que queremos leer ("GET") el archivo "json.json".
    xmlhttp.OPEN ("GET", "json.json");

    // Cuando la petición reciba la información, llamaremos a otra función para mostrarla.
    xmlhttp.onload = function(){
        mostrar(this);
    }

    // Enviamos la petición para que haga su trabajo.
    xmlhttp.send();
}

// Esta función toma la información que recibimos y la muestra en la página.
function mostrarJSON(xmlhttp){
    // Aquí guardamos la información que recibimos en un objeto llamado "jsObject".
    let jsObject, htmlCode, i, petsObject;
    
    // Convertimos la información en algo que podamos entender (un objeto de JavaScript).
    jsObject = JSON.parse(xmlhttp.responseText);

    // Creamos un mensaje para mostrar en la página.
    htmlCode = "<h3>" = jsObject + ", " + jsObject + " years old</h3>";

    // Recorremos una lista de mascotas que está dentro del objeto.
    for (let i in jsObject){
        // Guardamos cada mascota en una variable llamada "petsObject".
        petsObject = jsObject.pets[i];
        // Añadimos información de cada mascota a nuestro mensaje.
        htmlCode += "<li>" + jsObject["animal"] + ", " + petsObject["name"] + "/li";       
    }

    // Cerramos la lista de mascotas.
    htmlCode += "</ul>";

    // Mostramos el mensaje en un lugar de la página que tiene el nombre "resultado".
    document.getElementById("resultado").innerHTML = htmlCode;
}