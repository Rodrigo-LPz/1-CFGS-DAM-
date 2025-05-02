 /*Hace que JavaScript sea un poco más estricto con la grafía y normas de nombramientod de variables, constantes,etc.*/

let nBlncos = 0;
let nAsteriscos = 0;
let cadena = "";
let carácter1 = " ";
let carácter2 = "*";
let altura = prompt("Introduce la altura de la pirámide: ");
for (let i = 1; i <= altura; i++){
    nBlncos = altura - i;
    nAsteriscos = (2 * i) - 1;
    console.log(carácter1.repeat(nBlncos) + carácter2.repeat(nAsteriscos) + carácter1.repeat(nBlncos));
}
for (let i = altura - 1; i >= 1; i--){
    nBlncos = altura - i;
    nAsteriscos = (2 * i) - 1;
    console.log(carácter1.repeat(nBlncos) + carácter2.repeat(nAsteriscos) + carácter1.repeat(nBlncos));
}
console.log(cadena);