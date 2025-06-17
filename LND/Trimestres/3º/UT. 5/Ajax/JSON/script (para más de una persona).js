"use strict"

document.getElementById("cargar").addEventListener("click", cargarJSON);

function cargarJSON(){
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();

    xmlhttp.OPEN ("GET", "json.json");

    xmlhttp.onload = function(){
        mostrar(this);
    }

    xmlhttp.send();
}

function mostrarJSON(xmlhttp){
    let jsObject, htmlCode, i, personObject, j, petsObject;
    
    jsObject = JSON.parse(xmlhttp.responseText);
    
    // Inicializamos la cadena vacía para que no se pisen los datos/objetos.
    htmlCode = "";

    for (let i in jsObject.persons){
        personObject = jsObject.persons[i];
        htmlCode += "<h3>" + personObject + ", " + personObject.age + " years old</h3>";
        htmlCode += "<ul>";
        for (let j in jsObject){
            petsObject = jsObject.pets[j];
            htmlCode += "<li>" + jsObject["animal"] + ", " + petsObject["name"] + "/li";       
        }
    }
    
    htmlCode += "</ul>";

    document.getElementById("resultado").innerHTML = htmlCode;
}