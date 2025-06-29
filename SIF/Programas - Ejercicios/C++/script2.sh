#!/bin/bash
#Autor: Alejandro Lopez Santos

# Escribir un script que tome como argumentos dos ficheros F1 y F2 e imprima su contenido en líneas entrelazadas alternativamente:
# primero escribirá la primera línea de F1, luego la primera línea de F2, luego la segunda línea de F1, la segunda línea de F2
# y así sucesivamente. Si uno de los dos ficheros tiene menos líneas que el otro, cuando se acabe de mostrar el más corto
# el script escribirá el resto del contenido del más largo.
# Añadido: generalizar el script para que admita tres o más argumentos.

if [ $# -lt 2 ]
then
	echo "Debe introducir al menos dos parametros."
	exit 1
fi

fileLinesList=()
for files in "$@"
do
	fileLinesList+=($( wc -l $files | cut -d " " -f 1 ))
done

maxFileLines=0
for fileCount in "${fileLinesList[@]}"
do
	if [ $maxFileLines -lt $fileCount ]
	then
		maxFileLines=$fileCount
	fi
done

for count in $(seq 1 $maxFileLines)
do
	for files in "$@"
	do
		sed -n "${count}p" $files # Imprime la linea $count del fichero especificado
	done
done

exit 0