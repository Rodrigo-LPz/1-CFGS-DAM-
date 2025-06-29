#!/bin/bash
#Autor: Alejandro Lopez Santos

# Escribir un script que dadas dos carpetas A y B, muestre qué archivos están presentes solamente en una de las dos carpetas.
# Para cada archivo que cumpla esa condición, se mostrará su ruta completa (“A/fichero” o “B/fichero”, según el caso).
# El rastreo de archivos se hará sólo en el primer nivel de profundidad de las carpetas, no se hará recursivamente.
# Sólo se comparará el nombre de los archivos, no su tipo ni su contenido.
# Las rutas de las carpetas A y B se pasarán como argumentos al script.

if [ $# -ne 2 ]
then
	echo "Debe introducir dos directorios como parametros."
	exit 1
fi

function printFilesByPath {
	find $1 -maxdepth 1 -type f | while read file
	do
		fileMatch=$( find $2 -name "${file##*/}" ) # El operador ## es de extraccion de prefijo mas largo
		if [ -z $fileMatch ]
		then
			echo $file
		fi
	done
}

printFilesByPath $1 $2
printFilesByPath $2 $1

exit 0