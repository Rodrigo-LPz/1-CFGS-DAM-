/*(Apartado 1.8)*/
CREATE DATABASE Ejercicio_Apartado8;


USE Ejercicio_Apartado8





/*(Subapartado 1.8.1 → Procedimientos sin sentencias SQL)*/


-- Ejercicio 1. Escribe un procedimiento que no tenga ningún parámetro de entrada ni de salida y que muestre el texto "¡Hola mundo!".
DELIMITER $$

DROP PROCEDURE IF EXISTS Bienvenida$$

CREATE PROCEDURE Bienvenida()
BEGIN
    SELECT '¡Hola mundo!' AS mensaje;
END$$

DELIMITER ;


CALL Bienvenida;


-- Ejercicio 2. Escribe un procedimiento que reciba un número real de entrada y muestre un mensaje indicando si el número es positivo, negativo o cero.
DELIMITER $$

DROP PROCEDURE IF EXISTS EvaluarNumeros$$

CREATE PROCEDURE EvaluarNumeros(IN numero DECIMAL(10,2)) /* (10,2) = 10 dígitos y 2 decimales. Ejemplo, 8 enteros y 2 dígitos; 8 + 2 = 10dígitos. */
BEGIN
    IF numero < 0 THEN
        SELECT CONCAT ('El numero (', + numero, + ') es de caracter negativo') AS mensaje;
    ELSEIF numero = 0 THEN
        SELECT CONCAT ('El numero (', + numero, + ') "no es" de caracter ni negativo ni positivo') AS mensaje;
    ELSEIF numero > 0 THEN
        SELECT CONCAT ('El numero (', + numero, + ') es de caracter positivo') AS mensaje;
    END IF;
END$$

DELIMITER ;


CALL EvaluarNumeros(-4);
CALL EvaluarNumeros(0);
CALL EvaluarNumeros(8);


-- Ejercicio 3. Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor un número real, y un parámetro de salida, con una cadena de caracteres indicando si el número es positivo, negativo o cero.
DELIMITER $$

DROP PROCEDURE IF EXISTS EvaluarNumeros$$

CREATE PROCEDURE EvaluarNumeros(
    IN numero DECIMAL(10,2),
    OUT mensajeResultado VARCHAR(100) /* Es el número de cáracteres a poder salir. */
)
BEGIN
    IF numero < 0 THEN
        SET mensajeResultado = CONCAT ('El numero (', + numero, + ') es de caracter negativo');
    ELSEIF numero = 0 THEN
        SET mensajeResultado =  CONCAT ('El numero (', + numero, + ') "no es" de caracter ni negativo ni positivo');
    ELSEIF numero > 0 THEN
        SET mensajeResultado =  CONCAT ('El numero (', + numero, + ') es de caracter positivo');
    END IF;
END$$

DELIMITER ;


SET @resultado = ''; /* Esta línea no es obligatoria, pero ayuda a que la ejecución de la variable "resultado" no de errores en su compilación. Previene casos como por ejemplo, si la variable ha sido sobrescrita anteriormente o si por el contrario nunca ha sido inicializada. */

CALL EvaluarNumeros(7.5, @resultado); /* Llamamos al procedimiento pasándole un número y la variable para el resultado. */
SELECT @resultado; /* Mostramos el resultado almacenado en la variable. */


-- Ejercicio 4. Escribe un procedimiento que reciba un número real de entrada, que representa el valor de la nota de un alumno, y muestre un mensaje indicando qué nota ha obtenido teniendo en cuenta las siguientes condiciones:
    -- ([0,5) = Insuficiente | [5,6) = Aprobado | [6, 7) = Bien | [7, 9) = Notable | [9, 10] = Sobresaliente | En cualquier otro caso la nota no será válida.)
DELIMITER $$

DROP PROCEDURE IF EXISTS EvaluarNota$$

CREATE PROCEDURE EvaluarNota(IN nota DECIMAL(4,2))
BEGIN
    IF nota >= 0 AND nota < 5 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un insuficiente') AS mensaje;
    ELSEIF nota >= 5 AND nota < 6 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un aprobado') AS mensaje;
    ELSEIF nota >= 6 AND nota < 7 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un bien') AS mensaje;
    ELSEIF nota >= 7 AND nota < 9 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un notable') AS mensaje;
    ELSEIF nota >= 9 AND nota < 10 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un sobresaliente') AS mensaje;
    ELSEIF nota = 10 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a una matrícula de honor') AS mensaje;
    ELSE
        SELECT CONCAT('La nota introducida (', nota, ') es errónea o no válida') AS mensaje;
    END IF;
END$$

DELIMITER ;

CALL EvaluarNota(4.9);


-- Ejercicio 5. Modifique el procedimiento diseñado en el ejercicio anterior para que tenga un parámetro de entrada, con el valor de la nota en formato numérico y un parámetro de salida, con una cadena de texto indicando la nota correspondiente.
DELIMITER $$

DROP PROCEDURE IF EXISTS EvaluarNota$$

CREATE PROCEDURE EvaluarNota(
    IN nota DECIMAL(4,2),
    OUT mensajeResultado VARCHAR(200)
)
BEGIN
    IF nota >= 0 AND nota < 5 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un insuficiente') AS mensajeResultado;
    ELSEIF nota >= 5 AND nota < 6 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un aprobado') AS mensajeResultado;
    ELSEIF nota >= 6 AND nota < 7 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un bien') AS mensajeResultado;
    ELSEIF nota >= 7 AND nota < 9 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un notable') AS mensajeResultado;
    ELSEIF nota >= 9 AND nota < 10 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a un sobresaliente') AS mensajeResultado;
    ELSEIF nota = 10 THEN
        SELECT CONCAT('La nota obtenida (', nota, ') equivale a una matrícula de honor') AS mensajeResultado;
    ELSE
        SELECT CONCAT('La nota introducida (', nota, ') es errónea o no válida') AS mensajeResultado;
    END IF;
END$$

DELIMITER ;

SET @resultado = '';

CALL EvaluarNumeros(4.9, @resultado);
SELECT @resultado;


-- Ejercicio 6. Resuelva el procedimiento diseñado en el ejercicio anterior haciendo uso de la estructura de control "CASE".
DELIMITER $$

DROP PROCEDURE IF EXISTS EvaluarNota$$

CREATE PROCEDURE EvaluarNota(
    IN nota DECIMAL(4,2),
    OUT mensajeResultado VARCHAR(200)
)
BEGIN
    SET mensajeResultado = CASE
        WHEN nota >= 0 AND nota < 5 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a un insuficiente')
        WHEN nota >= 5 AND nota < 6 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a un aprobado')
        WHEN nota >= 6 AND nota < 7 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a un bien')
        WHEN nota >= 7 AND nota < 9 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a un notable')
        WHEN nota >= 9 AND nota < 10 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a un sobresaliente')
        WHEN nota = 10 THEN
            CONCAT('La nota obtenida (', nota, ') equivale a una matrícula de honor')
        ELSE
            CONCAT('La nota introducida (', nota, ') es errónea o no válida')
    END;
END$$

DELIMITER ;

CALL EvaluarNota(7, @mensajeResultado);
SELECT @mensajeResultado AS Resultado;


-- Ejercicio 7. Escribe un procedimiento que reciba como parámetro de entrada un valor numérico que represente un día de la semana y que devuelva una cadena de caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el valor de entrada "1" debería devolver la cadena "lunes". Resuelva el procedimiento haciendo uso de la estructura de control "IF".
DELIMITER $$

DROP PROCEDURE IF EXISTS ObtenerDiaSemana$$

CREATE PROCEDURE ObtenerDiaSemana(
    IN dia INT,
    OUT nombre VARCHAR(100)
)
BEGIN
    IF dia = 1 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el lunes');
    IF dia = 2 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el martes');
    IF dia = 3 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el miércoles');
    IF dia = 4 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el jueves');
    IF dia = 5 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el viernes');
    IF dia = 6 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el sábado');
    IF dia = 7 THEN
        SET nombre = CONCAT('El día de la semana (', dia, ') introducido es el domingo');
    ELSE
        SET nombre = CONCAT('El día de la semana (', nota, ') introducido es errónea o no válido');
    END IF;
END$$

DELIMITER ;

CALL EvaluarNota(3, @nombre);
SELECT @nombre AS Resultado;


-- Ejercicio 8. Resuelva el procedimiento diseñado en el ejercicio anterior haciendo uso de la estructura de control "CASE".
DELIMITER $$

DROP PROCEDURE IF EXISTS ObtenerDiaSemana$$

CREATE PROCEDURE ObtenerDiaSemana(
    IN dia INT,
    OUT nombre VARCHAR(100)
)
BEGIN
    SET dia = CASE
        WHEN nombre = 1 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el lunes')
        WHEN nombre = 2 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el martes')
        WHEN nombre = 3 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el miércoles')
        WHEN nombre = 4 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el jueves')
        WHEN nombre = 5 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el viernes')
        WHEN nombre = 6 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el sábado')
        WHEN nombre = 7 THEN
            CONCAT('El día de la semana (', dia, ') introducido es el domingo')
        ELSE
            CONCAT('El día de la semana (', nota, ') introducido es errónea o no válido')
       END;
END$$

DELIMITER ;

CALL EvaluarNota(10, @nombre);
SELECT @nombre AS Resultado;





/*(Subapartado 1.8.2 → Procedimientos con sentencias SQL)*/


-- Ejercicio 1. Escribe un procedimiento que reciba el nombre de un país como parámetro de entrada y realice una consulta sobre la tabla "cliente" para obtener todos los clientes que existen en la tabla de ese país.
USE jardineria;


DELIMITER $$

DROP PROCEDURE IF EXISTS ObtenerClientePais$$

CREATE PROCEDURE ObtenerClientePais(IN pais VARCHAR(100))
BEGIN
    SELECT c.nombre_cliente As nombre, c.region, c.pais 
    FROM cliente c
    WHERE c.pais = pais;
END$$

DELIMITER ;

CALL ObtenerClientePais('Spain');


-- Ejercicio 2. Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres (Ejemplo: "PayPal", "Transferencia", etc). Y devuelva como salida el pago de máximo valor realizado para esa forma de pago. Deberá hacer uso de la tabla "pago" de la base de datos "jardineria".
DELIMITER $$

DROP PROCEDURE IF EXISTS ObtenerPagoMaximo$$

CREATE PROCEDURE ObtenerPagoMaximo(
    IN formaPago VARCHAR(50),
    OUT pagoMaximo NUMERIC (15,2)
)
BEGIN
    SELECT MAX(total)
        INTO pagoMaximo /* "Into" se usa para almacenar el resultado en una variable en lugar de devolverlo directamente en una tabla de resultados. */
    FROM pago
    WHERE forma_pago = formaPago;
END$$

DELIMITER ;

CALL ObtenerPagoMaximo ('PayPal', @pagoMaximo);

SELECT @pagoMaximo AS "Pago Máximo";


-- Ejercicio 3. Escribe un procedimiento que reciba como parámetro de entrada una forma de pago, que será una cadena de caracteres (Ejemplo: "PayPal", "Transferencia", etc). Y devuelva como salida los siguientes valores teniendo en cuenta la forma de pago seleccionada como parámetro de entrada:
    -- (el pago de máximo valor, | el pago de mínimo valor, | el valor medio de los pagos realizados, | la suma de todos los pagos, | el número de pagos realizados para esa forma de pago.)
    -- (Deberá hacer uso de la tabla "pago" de la base de datos "jardineria".)
DELIMITER $$

DROP PROCEDURE IF EXISTS ObtenerDatosPago$$

CREATE PROCEDURE ObtenerDatosPago(
    IN formaPago VARCHAR(50),
    OUT pagoMaximo NUMERIC (15,2),
    OUT pagoMinimo NUMERIC (15,2),
    OUT MediaPago NUMERIC (15,2),
    OUT SumaPago NUMERIC (15,2),
    OUT TotalPago NUMERIC (15,2)
)
BEGIN
    SELECT MAX(total), MIN(total), AVG(total), SUM(total), COUNT(total)
        INTO pagoMaximo, pagoMinimo, MediaPago, SumaPago, TotalPago
    FROM pago
    WHERE forma_pago = formaPago;
END$$

DELIMITER ;

CALL ObtenerDatosPago('PayPal', @pagoMaximo, @pagoMinimo, @MediaPago, @SumaPago, @TotalPago);

SELECT @pagoMaximo AS "Pago máximo", 
       @pagoMinimo AS "Pago mínimo", 
       @MediaPago AS "Media de los pagos", 
       @SumaPago AS "Suma total de los pagos", 
       @TotalPago AS "Número total de pagos";


-- Ejercicio 4. Crea una base de datos llamada "procedimientos" que contenga una tabla llamada "cuadrados". La tabla "cuadrados" debe tener dos columnas de tipo "INT UNSIGNED", una columna llamada "número" y otra columna llamada "cuadrado".
    -- (Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado "calcular_cuadrados" con las siguientes características. El procedimiento recibe un parámetro de entrada llamado "tope" de tipo "INT UNSIGNED" y calculará el valor de los cuadrados de los primeros números naturales hasta el valor introducido como parámetro. El valor del números y de sus cuadrados deberán ser almacenados en la tabla "cuadrados" que hemos creado previamente.)
    -- (Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores de los cuadrados que va a calcular.)
    -- (Utilice un bucle "WHILE" para resolver el procedimiento.)
DROP DATABASE IF EXISTS procedimientos;

CREATE DATABASE procedimientos;

USE procedimientos;


DROP TABLE IF EXISTS NCuadrados;

CREATE TABLE NCuadrados(
    numero INT UNSIGNED NOT NULL,
    cuadrados INT UNSIGNED NOT NULL,
    PRIMARY KEY (numero)
)


DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_ncuadrados$$

CREATE PROCEDURE calcular_ncuadrados(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED DEFAULT 1; /* Se declara la variable numérica con el nombre "calculo" y con el valor (1) por defecto. Esta será la equivalente a la variable "tope" del procedimiento de la tabla "NCuadrados". */
    TRUNCATE TABLE NCuadrados; /* Limpiamos la tabla antes de insertar nuevos datos o valores. */
    WHILE valor <= tope DO
        INSERT INTO NCuadrados (numero, cuadrados) VALUES (valor, valor * valor);
        SET valor = valor + 1;
    END WHILE;
END$$

DELIMITER ;

CALL calcular_ncuadrados(10);
SELECT * FROM NCuadrados;


-- Ejercicio 5. Utilice un bucle "REPEAT" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_ncuadrados$$

CREATE PROCEDURE calcular_ncuadrados(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED DEFAULT 1; /* Se declara la variable numérica con el nombre "calculo" y con el valor (1) por defecto. Esta será la equivalente a la variable "tope" del procedimiento de la tabla "NCuadrados". */
    TRUNCATE TABLE NCuadrados; /* Limpiamos la tabla antes de insertar nuevos datos o valores. */
    REPEAT
        INSERT INTO NCuadrados (numero, cuadrados) VALUES (valor, valor * valor);
        SET valor = valor + 1;
    UNTIL valor > tope
    END REPEAT;
END$$

DELIMITER ;

CALL calcular_ncuadrados(10);
SELECT * FROM NCuadrados;


-- Ejercicio 6. Utilice un bucle "LOOP" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_ncuadrados$$

CREATE PROCEDURE calcular_ncuadrados(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED DEFAULT 1; /* Se declara la variable numérica con el nombre "calculo" y con el valor (1) por defecto. Esta será la equivalente a la variable "tope" del procedimiento de la tabla "NCuadrados". */
    TRUNCATE TABLE NCuadrados; /* Limpiamos la tabla antes de insertar nuevos datos o valores. */
    tabla: LOOP
        INSERT INTO NCuadrados VALUES (valor, valor * valor);
        SET valor = valor + 1;
        IF valor > tope then
            LEAVE tabla;
        END IF;
    END LOOP;
END$$

DELIMITER ;

CALL calcular_ncuadrados(10);
SELECT * FROM NCuadrados;


-- Ejercicio 7. Crea una base de datos llamada "procedimientos" que contenga una tabla llamada "ejercicio". La tabla debe tener una única columna llamada "número" y el tipo de dato de esta columna debe ser "INT UNSIGNED".
    -- (Una vez creada la base de datos y la tabla deberá crear un procedimiento llamado "calcular_números" con las siguientes características. El procedimiento recibe un parámetro de entrada llamado "valor_inicial" de tipo "INT UNSIGNED" y deberá almacenar en la tabla "ejercicio" toda la secuencia de números desde el valor inicial pasado como entrada hasta el 1.)
    -- (Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de las tablas antes de insertar los nuevos valores.)
    -- (Utilice un bucle "WHILE" para resolver el procedimiento.)
DROP DATABASE IF EXISTS procedimientos;

CREATE DATABASE procedimientos;

USE procedimientos;


DROP TABLE IF EXISTS ejercicio;

CREATE TABLE ejercicio(
    numero INT UNSIGNED NOT NULL,
    PRIMARY KEY (numero)
)

DELIMITER $$

DROP PROCEDURE IF EXISTS ContadorNumeros$$

CREATE PROCEDURE ContadorNumeros(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE ejercicio;
    SET valor = valor_inicial;
    WHILE valor >= 1 DO
        INSERT INTO ejercicio (numero) VALUES (valor);
        SET valor = valor - 1;
    END WHILE;
END$$

DELIMITER ;

CALL ContadorNumeros(10);
SELECT * FROM ejercicio;


-- Ejercicio 8. Utilice un bucle "REPEAT" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS ContadorNumeros$$

CREATE PROCEDURE ContadorNumeros(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE ejercicio;
    SET valor = valor_inicial;
    REPEAT
        INSERT INTO ejercicio (numero) VALUES (valor);
        SET valor = valor - 1;
    UNTIL valor < 1
    END REPEAT;
END$$

DELIMITER ;

CALL ContadorNumeros(10);
SELECT * FROM ejercicio;


-- Ejercicio 9. Utilice un bucle "LOOP" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS ContadorNumeros$$

CREATE PROCEDURE ContadorNumeros(IN valor_inicial INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE ejercicio;
    SET valor = valor_inicial;
    tabla: LOOP
        INSERT INTO ejercicio (numero) VALUES (valor);
        SET valor = valor - 1;
        IF valor < 1 THEN
            LEAVE tabla;
        END IF;
    END LOOP;
END$$

DELIMITER ;

CALL ContadorNumeros(10);
SELECT * FROM ejercicio;


-- Ejercicio 10. Crea una base de datos llamada "procedimientos" que contenga una tabla llamada "pares" y otra tabla llamada "impares". Las dos tablas deben tener única columna llamada "número" y el tipo de dato de esta columna debe ser "INT UNSIGNED".
    -- (Una vez creada la base de datos y las tablas deberá crear un procedimiento llamado "calcular_pares_impares" con las siguientes características. El procedimiento recibe un parámetro de entrada llamado "tope" de tipo "INT UNSIGNED" y deberá almacenar en la tabla "pares" aquellos números pares que existan entre el número 1 el valor introducido como parámetro. Habrá que realizar la misma operación para almacenar los números impares en la tabla "impares".)
    -- (Tenga en cuenta que el procedimiento deberá eliminar el contenido actual de las tablas antes de insertar los nuevos valores.)
    -- (Utilice un bucle "WHILE" para resolver el procedimiento.)
DROP DATABASE IF EXISTS procedimientos;

CREATE DATABASE procedimientos;

USE procedimientos;


DROP TABLE IF EXISTS pares, impares;

CREATE TABLE pares(
    numero INT UNSIGNED NOT NULL,
    PRIMARY KEY (numero)
);

CREATE TABLE impares(
    numero INT UNSIGNED NOT NULL,
    PRIMARY KEY (numero)
);


/* ----------------------------Para números únicamente positivos---------------------------- */
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_pares_impares$$

CREATE PROCEDURE calcular_pares_impares(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    SET valor = 1;
    WHILE valor <= tope DO
        IF valor % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (valor);
        ELSE
            INSERT INTO impares (numero) VALUES (valor);
        END IF;
        SET valor = valor + 1;
    END WHILE;
END$$

DELIMITER ;

CALL calcular_pares_impares(10);
SELECT * FROM pares;
SELECT * FROM impares;


/* ----------------------------Para números positivos y negaivos---------------------------- */
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_pares_impares$$

CREATE PROCEDURE calcular_pares_impares(IN tope INT) /* No usamos "UNSIGNED" ya que solo permite números positivos incluyendo al (0). */
BEGIN
    DECLARE valor INT;
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    SET valor = 1;
    IF tope >= 1 THEN /* Si "tope" es positivo o 1, entonces entramos en un bucle "WHILE" que incrementa "valor" de 1 en 1 hasta "tope". */
        WHILE valor <= tope DO
            IF valor % 2 = 0 THEN
                INSERT INTO pares (numero) VALUES (valor);
            ELSE
                INSERT INTO impares (numero) VALUES (valor);
            END IF;
            SET valor = valor - 1;
        END WHILE;
    ELSE /* En cambio, si "tope" es negativo , el bucle "WHILE" decrementa "valor" desde 1 hasta "tope". */
        WHILE valor >= tope DO
            IF valor % 2 = 0 THEN
                INSERT INTO pares (numero) VALUES (valor);
            ELSE
                INSERT INTO impares (numero) VALUES (valor);
            END IF;
            SET valor = valor + 1;
        END WHILE;
    END IF;
END$$

DELIMITER ;

CALL calcular_pares_impares(10);
SELECT * FROM pares;
SELECT * FROM impares;


-- Ejercicio 11. Utilice un bucle "REPEAT" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_pares_impares$$

CREATE PROCEDURE calcular_pares_impares(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    SET valor = 1;
    REPEAT
        IF valor % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (valor);
        ELSE
            INSERT INTO impares (numero) VALUES (valor);
        END IF;
        SET valor = valor + 1;
    UNTIL valor > tope
    END REPEAT;
END$$

DELIMITER ;

CALL calcular_pares_impares(10);
SELECT * FROM pares;
SELECT * FROM impares;


-- Ejercicio 12. Utilice un bucle "LOOP" para resolver el procedimiento del ejercicio anterior.
DELIMITER $$

DROP PROCEDURE IF EXISTS calcular_pares_impares$$

CREATE PROCEDURE calcular_pares_impares(IN tope INT UNSIGNED)
BEGIN
    DECLARE valor INT UNSIGNED;
    TRUNCATE TABLE pares;
    TRUNCATE TABLE impares;
    SET valor = 1;
    tabla: LOOP
        IF valor % 2 = 0 THEN
            INSERT INTO pares (numero) VALUES (valor);
        ELSE
            INSERT INTO impares (numero) VALUES (valor);
        END IF;
        SET valor = valor + 1;
        IF valor > tope THEN
            LEAVE tabla;
        END IF;
    END LOOP;
END$$

DELIMITER ;

CALL calcular_pares_impares(10);
SELECT * FROM pares;
SELECT * FROM impares;