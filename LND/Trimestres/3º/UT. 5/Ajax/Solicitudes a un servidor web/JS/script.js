document.getElementById("cargar").addEventListener("click", cargarProfesores);

function cargarProfesores(){
    let xhttp;

    xhttp = new XMLHttpRequest();
    xhttp.onload = function(){
        document.getElementById("archivo").value = this.responseTextM;
    };
    xhttp.open("GET", "profesores.txt");
    xhttp.send();
}