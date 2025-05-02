"Use strict";



document.getElementById("incrementButton").addEventListener("click", incrementCounter);

document.getElementById("decrementButton").addEventListener("click", decrementCounter);

document.getElementById("resetButton").addEventListener("click", resetCounter);


let counterDisplay = document.getElementById("counterDisplay");
let counterValues = 0;


function incrementCounter(){
    counterValues++;
    counterDisplay.innerHTML = counterValues;
}

function decrementCounter(){
    counterValues--;
    counterDisplay.innerHTML = counterValues;
}

function resetCounter(){
    counterValues = 0;
    counterDisplay.innerHTML = counterValues;

}