// Crear una función que reciba como argumento una letra y devuelva verdadero o falso (true o false) dependiendo de si es una vocal o no. Debe funcionar igual con mayúsculas y con minúsculas y por supuesto usando arrays. Solo se aceptan letras internacionales (sin acentos). ● Por ejemplo: esVocal('A') devolverá true, mientras que esVocal("z") devolverá false.

function esVocal(letra){
    // Declaramos un condicional de tipo "if" donde asegurarnos de que el usuario únicamente esté introduciendo un úncio valor y a suvez, que sea de tipo "String", es decir, no numérico.
    if (typeof letra !== 'string' || letra.length !== 1){ /* El argumento "typeOf" de vuelve el tipo de dato de la variable que se esta trabajando/tratando, por ejemplo, String, Int, Object, etc. */
        return false;
    } else{
        const esVocal = ['a', 'e', 'i', 'o', 'u'];
        return esVocal.includes(letra.toLowerCase()); /* El elemento ".include()" verifica si un elemento está dentro de un array o si una cadena contiene una subcadena específica. Es similar al ".indexOf", la diferencia es que este último es más complejo, pues devuelve la posición del array en valor numérico y (-1) para cuando esa posción no ha sid encontrada, teniendo que trabajar con situaciones aisladas. */
    }
}

// Pruebas.
console.log('( )  es ',esVocal(''));
console.log('(7)  es ',esVocal('7'));
console.log('(a)  es ',esVocal('a'));
console.log('(ao) es ',esVocal('ao'));
console.log('(z)  es ',esVocal('z'));
console.log('(A)  es ',esVocal('A'));
console.log('(Z)  es ',esVocal('Z'));