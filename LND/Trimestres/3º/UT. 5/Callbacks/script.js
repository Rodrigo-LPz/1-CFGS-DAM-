// Ejemplo de función que llama a otra que se le pasa como parámetro (síncrono).

const doSomethng = (callback) => {
    console.log("Doing something...");
    callback();
}
/*
Es lo mismo, pero la función de arriba no recibe nombre, es anónima, gracias a ( => )
    const doSomethng(callback){
        console.log("Doing something");
        callback();
    }
*/

const nextStep = () => {
    console.log("Callback function called.")
}

doSomethng(nextStep);


console.log("\n\n\n\n")


// Ejemplo de función que llama a otra conuna diferencia de tiempo entre la ejecución de una y otra (asíncrono).

// La función "setTimeout()" recibe com parámetro una función y una cantidad de tiempo.
// La funcón "callback" 
console.log("Before setTimeout()");

setTimeout(() => {
    console.log("Three seconds has passed.")
}, 3000); /* 3000ms = 3s */

console.log("After setTimeout()")