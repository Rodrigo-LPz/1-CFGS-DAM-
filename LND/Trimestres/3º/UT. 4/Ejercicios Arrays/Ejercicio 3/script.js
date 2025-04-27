// Realizar el siguiente script, haciendo uso de los métodos push(), pop(), shift() y unshift(): ● Declara un array que vamos a llamar «clasificaciones» con los siguientes valores (vamos a suponer que es el orden de clasificación de un concurso, en un momento dado): ○ Ana, Oswaldo, Raúl, Celia, María, Antonio ● Imprime la clasificación actual. ● El concurso continúa, y se modifican las posiciones anteriores. Debemos realizar estos cambios en el array: ○ Celia adelanta a Raúl. ○ Antonio es descalificado y se elimina del concurso. ○ Detrás de Ana y antes de Oswaldo se clasifican dos nuevos concursantes: Roberto y Amaya, en ese orden. ○ Hay una nueva participante que pasa a encabezar la clasificación: Marta. ○ Imprime la clasificación actualizada.

function Concurso(){

    let clasificaciones = ["Ana", "Oswaldo", "Raúl", "Celia", "María", "Antonio"];

    console.log("Clasificación actual: ", clasificaciones);

    //Reordenamos a Celia y a Raúl.
    let Antonio = clasificaciones.pop();
    let Maria = clasificaciones.pop();
    let Celia = clasificaciones.pop();
    let Raul = clasificaciones.pop();

    clasificaciones.push(Celia);
    clasificaciones.push(Raul);
    clasificaciones.push(Maria);
    clasificaciones.push(Antonio);

    clasificaciones.pop(); // Quitamos a Antonio.

    clasificaciones.shift(); // Quitamos a Ana.

    clasificaciones.unshift("Roberto", "Amaya"); // Añadimos a Roberto y Amaya.

    clasificaciones.unshift("Ana"); // Añadimos a Ana.

    clasificaciones.unshift("Marta"); // Ponemos encabeza a Marta.


    console.log("\nContinuación del concurso:");
    console.log("    1. Celia adelanta a Raúl");
    console.log("    2. Celia adelanta a Raúl");
    console.log("    3. Celia adelanta a Raúl");
    console.log("    4. Celia adelanta a Raúl");
    console.log("    5. Celia adelanta a Raúl\n");
    console.log("\nClasificación final/actualizada: ", clasificaciones);
}
Concurso();