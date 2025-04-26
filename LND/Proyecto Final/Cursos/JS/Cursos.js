/*
Definimos una función llamada "GoogleTranslate".
Esta función será ejecutada automáticamente cuando Google Translate cargue.
*/
function googleTranslateElementInit(){    
    /* Creamos un nuevo objeto de Google Translate y lo insertamos en la página. */
    new google.translate.TranslateElement(
        {
            /* Indicamos que el idioma original de la página es español (es). */
            pageLanguage: 'es',  

            /* Definimos la lista de los idiomas a los que se puede traducir [árabe (ar), alemán (de), inglés-americano (en), inglés-británico (en-GB), español-castellano (es), español-argentina (es-ar), español-colombia (es-co), español-méxico (es-mx), catalán (ca), euskera (eu), francés (fr), italiano (it), japonés (ja), coreano (ko), ruso (ru), chino-simplificado (zh-CN), portugués (pt), portugués-brasileño (pt-BR), hindi (hi), latín (la)]. */
            includedLanguages: 'ar,de,en,en-GB,es,es-ar,es-co,es-mx,ca,eu,fr,it,ja,ko,ru,zh-CN,pt,pt-BR,hi,la',

            /* Configuramos el diseño del widget de traducción (traductor) para que sea simple. */
            layout: google.translate.TranslateElement.InlineLayout.SIMPLE  
        },
        /* Especificamos el ID del elemento HTML donde se insertará el traductor. */
        'GoogleTranslate' 
    );
    /* Damos más tiempo para que Google Translate cargue correctamente. (también se puede dar este tiempo de carga para aplicar a estilos, lo que al estar puestos ya en el css, en este caso, únicamente tendrá una función funcional y no estética)*/
    setTimeout(() => {
    }, 500); /* Esto equivale a 500 milisegundos = 0.5 segundos. Es el tiempo que ponemos nosotros para asegurarse de que Google Translate cargue. */
}
/* Después de la primera carga introducimos un evento donde, en este caso, cambiaremos el texto del traductor. */
document.addEventListener("DOMContentLoaded", function(){
    /* Damos más tiempo para que Google Translate cargue correctamente. (también se puede dar este tiempo de carga para aplicar a estilos, lo que al estar puestos ya en el css, en este caso, únicamente tendrá una función funcional y no estética)*/
    setTimeout(() => {
        let translateButton = document.querySelector(".goog-te-gadget-simple span");
        if (translateButton){
            translateButton.innerHTML = "🗣️🌐"; // Reemplaza el texto por un emoji
        }
    }, 2000); /* Esto equivale a 2000 milisegundos = 2 segundos. Es el tiempo que ponemos nosotros para asegurarse de que Google Translate cargue. */
})