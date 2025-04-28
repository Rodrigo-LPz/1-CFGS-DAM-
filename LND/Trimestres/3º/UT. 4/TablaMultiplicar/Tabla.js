// let numero = prompt("Introduce un número a multiplicar: ");
// let contador = 0;
// for (let i = 1; i <= 10; i++){
//     contador ++;
//     console.log(numero + " x " + contador + " = " + (numero * contador));
// }

let tabla1 = 1;
let tabla2 = 10;
let numero = 0;
let cadena = "";
for (let i = tabla1; i <= tabla2; i++){
    cadena += "\nTabla del número " + String(i) + ":\n";
    for (let j = numero; j <= 10; j++){
        if (j % 2 === 0){
            cadena += String(i) + " x " + String(j) + " = " + String(i * j) + "\n";        } else {
        }
    }
}
console.log(cadena);