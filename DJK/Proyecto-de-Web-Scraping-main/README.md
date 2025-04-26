<h1 align="center">Proyecto-de-Web-Scraping</h1>
<h6>1º CFGS - DJK (Digitalización aplicada a los sectores productivos (GS))</h6>
<h6 align="right">Hecho por Alexander Gómez Gutiérrez y Rodrigo López Pérez</h6>

<hr><br><br><br>

<h3>Proyecto de Web Scraping para Monitorización de Precios 🛍️💻</h3>
<p>¡Bienvenido/a! Este repositorio contiene el desarrollo de un sistema de Web Scraping para monitorizar precios de productos en diferentes sitios web, con ayuda de IA para la generación de código y Pair Programming para fomentar la colaboración y el trabajo en equipo.</p>

<br>

<h3>Tabla de Contenidos 📋</h3>
<ol>
  <li>Objetivo General</li>
  <li>Características Principales</li>
  <li>Estructura del Proyecto</li>
  <li>Cronograma de Trabajo</li>
  <li>Detalle de Sesiones</li>
  <li>Requerimientos de Herramientas y Recursos</li>
  <li>Criterios de Evaluación</li>
  <li>Entrega y Presentación Final</li>
  <li>Ejecutar programa</li>
  <li>Cómo Contribuir</li>
  <li>Licencia</li>
</ol>

<br><hr>

<h3>🔍 Objetivo general 🤔</h3>
<p>Desarrollar un sistema que permita automatizar la recolección y análisis de datos de diferentes sitios web para la monitorización de precios, aprovechando o empleando los siguientes aspectos a mencionar:</p>
<ul>
  <li>IA para la generación de código.</li>
  <li>Programación en pares (Pair Programming) para revisar y mejorar la calidad del código.</li>
  <li>Buenas prácticas de programación y documentación.</li>
</ul>

<br>

<h3>🖊️ Características Principales 📋</h3>
<ul>
  <li>Scraping de datos relevantes (tipo de domicilio, precios, descripciones, fechas, ubicación).</li>
  <li>Almacenamiento de la información en formatos JSON.</li>
  <li>Programación de tareas periódicas para mantener los datos actualizados (cron jobs).</li>
  <li>Validación y manejo de errores para garantizar la robustez del sistema.</li>
  <li>Documentación completa y ejemplos de uso.</li>
</ul>

<br>

<h3>🏗️ Estructura del Proyecto 🏛️</h3>
   
   ```
   Spyprice
   ├── Proyecto-de-Web-Scrapping
      ├── datos_productos.csv
      ├── README.md
      ├── webScrapper.py
   ```

<br>

<h3>⌚ Cronograma de Trabajo 💹</h3>

| <div align="center">**Sesión**</div> | <div align="center">**Tema**</div>                 | <div align="center">**Duración**</div> | <div align="center">**Fecha**</div> |
| -----------------------------------: | :------------------------------------------------- | :------------------------------------: | ----------------------------------: |
| 1                                    | Creación de Estructura y Configuración del Entorno | 1 hora                                 | 06/02/2025                          |
| 2                                    | Parsing del HTML y Extracción de Datos             | 1 hora                                 | 12/02/2025                          |
| 3                                    | Almacenamiento de Datos y Actualización Periódica  | 1 hora                                 | 13/02/2025                          |
| 4                                    | Integración, Validación y Manejo de Errores        | 1 hora                                 | 19/02/2025                          |
| 5                                    | Documentación, Pruebas y Presentación Final        | 1 hora                                 | 20/02/2025                          |
| 6                                    | Repaso, Ajustes Finales y Cierre del Proyecto      | 1 hora                                 | 26/02/2025                          |

<br>

<h3>✨ Detalle de Sesiones 🔰</h3>
<ol>
  <li>Creación de Estructura y Configuración del Entorno (⏱️ 1 hora)</li>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Definir repositorio y estructura de carpetas.</li>
          <li>Configurar entorno local (Python, librerías, herramientas de IA).</li>
          <li>Estructuración del equipo (alinear roles) y responsabilidades (Pair Programming).</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Crear repositorio y README inicial.</li>
          <li>Instalar y probar herramientas de IA (por ejemplo: GitHub Copilot, Tabnine) → (En este caso usaremos GPT-4 sobre el IDE VSCode).</li>
          <li>Configurar el entorno virtual y librerías (requests, BeautifulSoup, etc).</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Repositorio con estructura básica.</li>
          <li>Ambiente virtual listo y probado de antemano.</li>
        </ul>
    </ul>
  <br>
  <li>Parsing del HTML y Extracción de Datos (🕵️‍♂️ 1 hora)</li>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Implementar la lógica de scraping con ayuda de la IA.</li>
          <li>Probar métodos de extracción de elementos HTML (tipo de domicilio, precios, descripciones, fechas, ubicación).</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Diseñar la función principal de scraping.</li>
          <li>Usar librerías como requests y BeautifulSoup.</li>
          <li>Parsear información clave (clases, IDs, etiquetas).</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Código funcional del scraping para al menos un sitio de prueba.</li>
          <li>Documentación básica de la estructura HTML.</li>
        </ul>
    </ul>
  <br>
  <li>Almacenamiento de Datos y Actualización Periódica (💾 1 hora)</li>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Crear la estructura de almacenamiento (CSV, JSON, SQLite, DB, etc.).</li>
          <li>Programar la lógica de actualización automática (cron jobs, schedulers).</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Decidir formato de almacenamiento, en este caso usaremos JSON.</li>
          <li>Configurar tareas programadas para el scraping periódico.</li>
          <li>Validar la integridad de los datos.</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Script o configuración de tarea programada.</li>
          <li>Esquema de datos y archivos de ejemplo.</li>
        </ul>
    </ul>
  <br>
  <li>Integración, Validación y Manejo de Errores (🔧 1 hora)</li>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Integrar el sistema de scraping con el almacenamiento.</li>
          <li>Implementar el manejo de errores y excepciones.</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Revisar flujo de datos completo.</li>
          <li>Añadir validaciones (precios numéricos, fechas válidas, ubicación real).</li>
          <li>Manejar excepciones (tiempo de espera, desconexión, captchas).</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Código robusto con validaciones y manejo de excepciones.</li>
          <li>Log de errores y soluciones.</li>
        </ul>
    </ul>
  <br>
  <li>Documentación, Pruebas y Presentación Final (📑✅ 1 hora)</li>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Crear documentación clara (Manual de Usuario y Técnico).</li>
          <li>Diseñar y ejecutar pruebas de funcionalidad (unitarias, integración).</li>
          <li>Preparar la presentación final (diapositivas, demo).</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Redactar documentación en README o Wiki</li>
          <li>Implementar pruebas unitarias al ejecutar y compilar el programa en VSCode</li>
          <li>Preparar la demo o prueba para visualización en vivo.</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Documentación final.</li>
          <li>Conjunto de pruebas unitarias.</li>
          <li>Presentación (diapositivas, video o demostración en vivo del programa).</li>
        </ul>
    </ul>
  <br>
  <li>Repaso, Ajustes Finales y Cierre del Proyecto (🎉 1 hora) ↴</li>
  <h6>(Hemos decidido añadir una sesión más a pesar de que la 5º sesión podría ser la última. En esta última sesión damos por finalizado el proyecto tras darle un último vistazo a los posibles errores durante la demostración del trabajo, al cierre del código y, en caso excepcional, retoque de ajustes finales, por ejemplo: optimización del código)</h6>
    <ul>
      <li>Objetivos</li>
        <ul>
          <li>Resolver dudas pendientes y realizar ajustes de última hora.</li>
          <li>Realizar retrospectiva (qué funcionó, qué mejorar).</li>
          <li>Cierre oficial del proyecto.</li>
        </ul>
      <li>Actividades</li>
        <ul>
          <li>Revisión de feedback de pruebas</li>
          <li>Ajustes finales (refactorización, optimización).</li>
          <li>Entrega y clausura del proyecto.</li>
        </ul>
      <li>Entregables</li>
        <ul>
          <li>Proyecto final listo para uso general o despliegue del mismo.</li>
          <li>Informe de retrospectiva (objetivos conseguidos, valoración de la ruta tomada como equipo, etc.).</li>
        </ul>
    </ul>
  <br>
<br><hr>
  
<h3>🧰 Resumen (Requerimientos de Herramientas y Recursos) ⚡</h3>
<ul>
  <li>**Lenguaje** → Python 3.x.</li>
  <li>**Librerías** → requests, BeautifulSoup, pandas (opcional), pytest (para pruebas).</li>
  <li>**IA de Generación de Código** → ChatGPT o GPT-4 sobre el IDE VSCode</li>
  <li>**Control de Versiones** → Git.</li>
  <li>**Entorno de Desarrollo** → Visual Studio Code con GPT-4 como asistente.</li>
  <li>**Documentación** → Markdown (README, Wiki), Google Docs, etc. Y, presentación en vivo del proyecto.</li>
</ul>

<br>

<h3>👨‍💻 Ejecutar la Aplicación 🏃</h3>
<ol>
   <li>Abre la terminal.</li>
   <li>Clona el repositorio:</li>
   
      ```
      git clone <repository-url>
      ```
      
   <li>Navega al directorio del proyecto:</li>
   
      ```
      cd Proyecto-de-Web-Scraping
      ```
      
   <li>Instalar las librerías:</li>
   
      ```
      pip install [Nombre-Libreria]
      ```
      
   <li>Ejecuta la aplicación:</li>
   
      ```
      python3 webScrapper.py
      ```
</ol>

<br>

<h3>🎁 Cómo Contribuir 🤝</h3>
<p>¡Las contribuciones son bienvenidas! No dudes en enviar una solicitud de extracción o abrir un problema para cualquier mejora o corrección de errores. Para ello realiza lo siguiente:</p>
<ol>
  <li>**Haz un fork de este repositorio.**</li>
  <li>**Crea una nueva rama con tu feature o corrección** (git checkout -b feature/nueva-funcionalidad).</li>
  <li>**Realiza tus cambios y haz commits descriptivos.**</li>
  <li>**Envía un pull request para que podamos revisar tu propuesta.**</li>
</ol>
<p>**¡Siéntete libre de usarlo y mejorarlo!**</p>

<br>

<h3>📊 Licencia ⚖️</h3>
<p>Este proyecto se distribuye/está licenciado bajo la **MIT License.**Consulta el archivo LICENSE para más detalles →  https://es.wikipedia.org/wiki/Licencia_MIT<p>

<br>

<h3>🙏 Agradecimientos 🙌</h3>
<p>Si tienes dudas o sugerencias, no dudes en abrir un Issue o enviar un Pull Request.</p>
<p>¡Feliz programación! 🏆✨<p>

<hr><br><br>

<h1>¡Gracias por visitar este repositorio!</h1>
