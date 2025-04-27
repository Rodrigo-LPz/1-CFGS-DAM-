"use strict";

// Carga la clasificación de la liga.
window.addEventListener("load", tablaClasificatoria); /* A diferencia de "document.addEventListener" usando "window.addEventListener" la función 'tablaClasificatoria' cargará su ejecución una vez han cargado todos los archivos de la página (HTML, CSS, JS, imágenes, etc.). En cambio, si se usase "document." la función "tablaClasificatoria" cargaría su ejecución sólo tras la carga del archivo (HTML). */

// Función "tablaClasificatoria", con la que cargar la tabla de clasificación de 'LaLiga'.
function tablaClasificatoria(){
  // Crea el objeto "XMLHttpRequest" para realizar la petición al servidor.
  let xhttp = new XMLHttpRequest(); /* "XMLHttpRequest" es un objeto que permite realizar peticiones HTTP desde JavaScript. */

  // Ejecuta la función "mostrarClasificatoria()" cuando la petición "XMLHttpRequest" se hay completado correctamente.
  xhttp.onload = function (){ mostrarClasificatoria(this); };
  
  // Indica que se va a realizar una petición (de obtención de información) de tipo 'GET' al archivo "clasificacion.xml".
  xhttp.open("GET", "XML/clasificacion.xml", true);
  xhttp.send();
}

// Función "mostrarClasificatoria", con la que mostrar la tabla de clasificación de 'LaLiga'.
function mostrarClasificatoria(xml){
  // Se crean las variables "xmlDoc", "equipos" y "tabla" para almacenar el objeto 'XML', los equipos y la tabla de clasificación respectivamente.
  let xmlDoc, equipos, tabla;

  // Se obtiene el objeto de tipo "XML" de la respuesta dada por el servidor partiendo del objeto "XMLHttpReponse".
  xmlDoc = xml.responseXML;

  // Se obtiene la lista de equipos del objeto "XML" a partir de la etiqueta "team" que contiene la información de cada uno de los equipos.
  equipos = xmlDoc.getElementsByTagName("team");

  // Se crea la variable "tabla" para almacenar el código HTML de la tabla de clasificación.
  tabla = "<table>"; /* [Sería lo mismo a ir al archivo (HTML) e ir creando la tabla declarar los diferentes elementos, <table>]. */

  // Se crea el formato de la tabla, en este caso las columnas (Equipo, Pts, PJ, PG, PE, PP, GF y GC).
  tabla += "<tr><th>Equipo</th><th>Pts</th><th>PJ</th><th>PG</th><th>PE</th><th>PP</th><th>GF</th><th>GC</th></tr>";

  // Se recorre la lista de equipos obtenida del objeto "XML" y se va creando el código HTML para cada fila de la tabla.  
  for (let i = 0; i < equipos.length; i++){
    // Se crean las variables "nombre", "orden", "puntos", "jugados", "ganados", "empatados", "perdidos", "gf" y "gc" para almacenar los datos de cada equipo.
    let nombre, orden, puntos, jugados, ganados, empatados, perdidos, gf, gc;

    // Se asignan las variables de cada uno de los datos del archivo (XML).
      /* Explicación:
      * Primero accedemos al elemento <name> (del "XML") del equipo actual (posición [0] porque solo hay uno).
      * Luego, accedemos al primer hijo de ese elemento, que es un nodo de tipo texto (childNodes[0]).
      * Finalmente, obtenemos el contenido de texto de ese nodo usando .nodeValue.
      */
    nombre = equipos[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
    orden = equipos[i].getElementsByTagName("rank")[0].childNodes[0].nodeValue;
    puntos = equipos[i].getElementsByTagName("points")[0].childNodes[0].nodeValue;
    jugados = equipos[i].getElementsByTagName("played")[0].childNodes[0].nodeValue;
    ganados =equipos[i].getElementsByTagName("won")[0].childNodes[0].nodeValue;
    empatados =equipos[i].getElementsByTagName("drawn")[0].childNodes[0].nodeValue;
    perdidos =equipos[i].getElementsByTagName("lost")[0].childNodes[0].nodeValue;
    gf =equipos[i].getElementsByTagName("goals_scored")[0].childNodes[0].nodeValue;
    gc =equipos[i].getElementsByTagName("goals_conceded")[0].childNodes[0].nodeValue;

    // Se crea la variable "clase" para asignar los estilos/colores declarados en el "CSS".
    let clase = "";
    if (i < 4){
      clase = "champions";
    } else if (i === 4){
      clase = "europa";
    } else if (i === 5){
      clase = "conference";
    } else if (i >= Math.max(0, equipos.length - 4)){ /* La función "Math.max" se utiliza para asegurar que no obtenemos índices negativos. También podríamos poner lo siguiente: (i >= equipos.length - 4). */
      clase = "descenso";
    }

    // Se construye una fila de la tabla con los datos del equipo, añadiendo la clase correspondiente a la fila según el equipo (Si antes hicimos las columnas, ahora las filas).
    tabla += "<tr class='" + clase + "'>" +
      "<td>" + orden + ". " + nombre + "</td>" +
      "<td>" + puntos + "</td>" +
      "<td>" + jugados + "</td>" +
      "<td>" + ganados + "</td>" +
      "<td>" + empatados + "</td>" +
      "<td>" + perdidos + "</td>" +
      "<td>" + gf + "</td>" +
      "<td>" + gc + "</td>" +
    "</tr>";
  }

  // Se cierra la tabla.
  tabla += "</table>";

  // Insercción del trabajo realizado, de la tabla dentro del div "tablaClasificacion" en el documento (HTML).
  document.getElementById("tablaClasificacion").innerHTML = tabla;
}