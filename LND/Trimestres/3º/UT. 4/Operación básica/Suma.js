"Use strict"; /*Hace que JavaScript sea un poco más estrictito con la grafía y normas de nombramientod de variables, constantes,etc.*/

let num;

while (num === undefined){
    num = prompt("Ingrese un número:");
    if (num === null || num.trim() === "") {
        alert("Por favor, ingrese un número válido.");
    } else if (isNaN(num)){
        alert("Solo se aceptan valores numéricos.");
    } else {
        num = Number(num);
        break;
    }
}
if (num % 2 === 0){
    console.log("El número " + num + " es par");
} else{
    console.log("El número " + num + " es impar");
}