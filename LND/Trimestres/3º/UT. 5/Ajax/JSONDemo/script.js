document.getElementById("cargar").addEventListener("click", cargarJSON);

function cargarJSON() {
    let xmlhttp;

    xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function() {
        mostrarJSON(this);
    };
    xmlhttp.open("GET", "json_demo.txt");
    xmlhttp.send();
}

function mostrarJSON(xmlhttp) {
    let jsObject, htmlCode, i, petObject;

    jsObject = JSON.parse(xmlhttp.responseText);
    htmlCode = "<h3>" + jsObject.name + ", " + jsObject.age + " years old.</h3>";
    for (i in jsObject.pets) {
        petObject = jsObject.pets[i];
        htmlCode += "<ul>";
        htmlCode += 
            "<li>" + petObject["animal"] + ", " + petObject["name"] + "</li>";
        htmlCode += "</ul>";

        }
 
    document.getElementById("resultado").innerHTML = htmlCode;
}