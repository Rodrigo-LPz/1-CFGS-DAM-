"use strict";

document.getElementById("container").addEventListener("click", modificator);

function modificator(){
    // Creamos una variable con los dígitos de hexadecimal.
    let hexadecimalDigit = "0123456789abcdef";
    console.log(hexadecimalDigit[Math.floor(Math.random() * 16)]); /* El atributo "floor" trunca a las unidades. */
    
    let color = "";
    color = "#";
    for (let i = 0; i < 6; i++){
        color += hexadecimalDigit[Math.floor(Math.random() * 16)];
    }

    document.getElementById("container").style.backgroundColor = color;
    document.getElementById("code").innerHTML = "Code color: " + color;
}