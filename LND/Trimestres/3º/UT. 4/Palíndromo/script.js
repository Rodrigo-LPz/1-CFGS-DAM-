// Declaramos que 'JavaScript' sea más estricto léxico-semánticamente.
"use strict";


// Manejador del evento al hacer click ("click") al boton "boton". Se llama a la función "palindromeChecker"
document.getElementById("checkButton").addEventListener("click", palindromeChecker);

// Creamos una función "esPalindromo" para verificar si la parabla introducida "palabra" es igual sintácticamente "palabraNormal" después de invertirla "PalabraReversa".
function isPalindrome(word){
    const normalWord = word.toLowerCase();
    /* Elementos/Atributos: 
        • "split"   → Trasforma la cadena en Array partiendo del separador indicado " ("") " Ejemplo, si introdujésemos 'Esto es palíndromo', crearía un array de 3 filas/espacios/elementos: {Esto, es, palíndromo}.
        • "reverse" → Contruye el Array de forma inversa, del revés, creado con el "split". Siguiendo con el ejemplo: {palíndromo, es, Esto}
        • "join"    → Transforma o convierte el array obtenido por 
    */
    const reverseWord = normalWord.split("").reverse().join("");

    console.log(normalWord);
    console.log(reverseWord);

    // Declaramos un bucle de tipo "if" con el que comparar las dos constantes de la misma palabra, la normal y la inversa/invertida.
    if (normalWord === reverseWord){
        return true;
    } else{
        return false;
    }

    /* Otra opción a hacer el comprobante. */
    // return (palabraNormal === PalabraReversa);
}

function palindromeChecker(){
    const inputText = document.getElementById("inputText");
    const result = document.getElementById("result");

    if (inputText.value.trim() === ""){
        result.innerHTML = "⚠️ Please enter a correct sentence (word or number). ⚠️";
        result.classList.remove("green", "red");
        result.classList.add("error");
        return;
    }

    if (isPalindrome(inputText.value)){
        result.innerHTML = "✅ (" + inputText.value + ") is a palindrome. ✅";
        result.classList.remove("red");
        result.classList.add("green");
    } else{
        result.innerHTML = "❌ (" + inputText.value + ") is not a palindrome. ❌";
        result.classList.remove("green");
        result.classList.add("red");
    }

    // Reseteo del contenedor del texto.
    inputText.value = "";
}