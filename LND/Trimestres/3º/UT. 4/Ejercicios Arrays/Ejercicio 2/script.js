// Crear una función que dado un array de números debe retornar los números únicos dentro de ese array y ordenarlos de menor a mayor,. ● Por ejemplo: procesarArray([1, 2, -3, -1, 2, 4, 4, 1, 45, -1]) devolverá [ -3, -1, 1, 2, 4, 45].

function procesarArray(){
    // Declaramos una función con la que leer el array (declarado posteriormente) donde leerá el elemento, la posición y el array del mismo.
    function eliminarDuplicados(elemento, posicion, array){
        return array.indexOf(elemento) === posicion; /* Usamos el argumento "indexOf" para almacenar la primera aparición de un elemento, en caso de que ese mismo elemento vuelva aparecer, este lo "ignorará", lo borrará declarándolo comoo 'false'. */
    }

    // Declaramos una función con la que ordenar de forma ascendente los valores, donde el primer valor "x" si es mayor a su consiguiente dentro del array, la "y", la "y" se posiciona primero, de forma inversa ocurriría si la "x" fuese de un valor menor; y, (0) si fuesen iguales.
    function ordenarAscendente(x, y){
        if (x > y){
            return 1;
        } else if (x < y){
            return -1;
        } else{
            return 0;
        }
    }

    // Creamos el array a ser leído.
    let arraynumeros = [1, 2, -3, -1, 2, 4, 4, 1, 45, -1];

    // Con "filter" filtramos usando la función declarada anteriormente como 'eliminarDuplicados'. Mientras que con "sort", ordenamos usando la función nombrada anteriormente como 'ordenAscendente'.
    arraynumeros = arraynumeros.filter(eliminarDuplicados).sort(ordenarAscendente);
    console.log("Array modificado (ordenado de menor a mayor y sin duplicados): ", arraynumeros.toString(arraynumeros));

    /* Utilizamos la declaración del array como "let" ya que vamos modificando su contenido con el "filter" y el "sort". */
}

// Ejecución de la función 'procesarArray'.
procesarArray();