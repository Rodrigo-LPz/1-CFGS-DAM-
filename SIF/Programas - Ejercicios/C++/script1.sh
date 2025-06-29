#!/bin/bash

# Definicion de colores
AZUL="34"
VERDE="32"
NEGRITAVERDE="\e[1;${VERDE}m"
NEGRITAAZUL="\e[1;${AZUL}m"
FINCOLOR="\e[0m"

# Script
echo -e "${NEGRITAVERDE}=====================================${FINCOLOR}"
echo -e "         ${NEGRITAVERDE}Reporte del Sistema${FINCOLOR}         "
echo -e "${NEGRITAVERDE}=====================================${FINCOLOR}"
echo
echo -e "${NEGRITAVERDE}===== Información del sistema =====${FINCOLOR}"
echo -e "${NEGRITAAZUL}Fecha y hora${FINCOLOR}: $(date)"
echo -e "${NEGRITAAZUL}Hostname${FINCOLOR}: $(hostname)"
echo -e "${NEGRITAAZUL}Tiempo encendido${FINCOLOR}: $(uptime -p)"
echo
echo -e "${NEGRITAAZUL}Sistema Operativo${FINCOLOR}: $(uname -o)"
echo -e "${NEGRITAAZUL}Versión Kernel${FINCOLOR}: $(uname -r)"
echo -e "${NEGRITAAZUL}Arq. Procesador${FINCOLOR}: $(uname -p)" 
echo -e "${NEGRITAAZUL}Distribución${FINCOLOR}: $(cat /etc/os-release | grep "PRETTY_NAME" | cut -d '"' -f 2)"
echo
echo -e "${NEGRITAVERDE}===== Información de CPU =====${FINCOLOR}"
echo -e "${NEGRITAAZUL}CPU Model${FINCOLOR}: $(grep "model name" /proc/cpuinfo | head -1 | cut -d ':' -f 2 | sed 's/^[ \t]*//')"
echo -e "${NEGRITAAZUL}CPU Cores${FINCOLOR}: $(grep -c "processor" /proc/cpuinfo)"
echo
echo -e "${NEGRITAVERDE}===== Uso del disco =====${FINCOLOR}"
df -h | grep -E "^Filesystem|^/dev/"
echo
echo -e "${NEGRITAVERDE}===== Uso de RAM =====${FINCOLOR}"
free -h
echo
echo -e "${NEGRITAVERDE}===== Uso de CPU =====${FINCOLOR}"
top -bn1 | head -5
echo
echo -e "${NEGRITAVERDE}=====================================${FINCOLOR}"
echo -e "           ${NEGRITAVERDE}Fin del reporte${FINCOLOR}           "
echo -e "${NEGRITAVERDE}=====================================${FINCOLOR}"