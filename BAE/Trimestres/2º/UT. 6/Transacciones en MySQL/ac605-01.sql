/*(Apartado 1)*/
SET AUTOCOMMIT = 1;
SELECT @@AUTOCOMMIT;

DROP DATABASE IF EXISTS test;
CREATE DATABASE test CHARACTER SET utf8mb4;
USE test;

CREATE TABLE cliente(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    saldo DECIMAL(10,2) DEFAULT 0.00
);
INSERT INTO cliente (id, nombre, saldo) VALUES
(1, 'Ana', 1000.00),
(2, 'Carlos', 500.00),
(3, 'Marta', 1500.00);





-- Ejercicio 1. Ejecutar esta consulta y registrar resultados.
SELECT * FROM cliente;


-- Ejercicio 2.  Intentar deshacer cambios (¿Qué ocurre?).
ROLLBACK;


-- Ejercicio 3. Verificar estado actual de la tabla.
SELECT * FROM cliente;


-- Ejercicio 4. Transacción 1 (Ejecutar en sesión A).
START TRANSACTION;

UPDATE cliente SET saldo = saldo - 200 WHERE id = 1;
UPDATE cliente SET saldo = saldo + 200 WHERE id = 2;
/* No hacer COMMIT todavía. */


-- Ejercicio 5. Transacción 2 (Ejecutar en sesión B mientras la 1 está activa).
START TRANSACTION;

UPDATE cliente SET saldo = saldo - 100 WHERE id = 2;
UPDATE cliente SET saldo = saldo + 100 WHERE id = 3;

COMMIT;


-- Ejercicio 6. En sesión A: Intentar COMMIT después del conflicto.
COMMIT;


-- Ejercicio 7. Analizar resultados finales.
SELECT * FROM cliente;


-- Ejercicio 8. Investigar bloqueos (Ejecutar en tercera sesión).
SHOW ENGINE INNODB STATUS;


-- Ejercicio 9. Resetear datos.
SET AUTOCOMMIT = 1;

DELETE FROM cliente;
INSERT INTO cliente (id, nombre, saldo) VALUES
(1, 'Ana', 1000.00),
(2, 'Carlos', 500.00),
(3, 'Marta', 1500.00);


-- Ejercicio 10. Transacción concurrente con SLEEP.

    -- Sesión A:
    START TRANSACTION;

    UPDATE cliente SET saldo = saldo - 300 WHERE id = 1;
    DO SLEEP(10);
    UPDATE cliente SET saldo = saldo + 300 WHERE id = 3;
    
    COMMIT;

    -- Sesión B:
    START TRANSACTION;

    UPDATE cliente SET saldo = saldo - 200 WHERE id = 1;

    COMMIT;


-- Ejercicio 11. Verificar estado final.
SELECT * FROM cliente;


-- Ejercicio 12. Experimentar con niveles de aislamiento.
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;

START TRANSACTION;

SELECT * FROM cliente WHERE id = 1;

    -- Ejecutar actualización en otra sesión
    COMMIT;


-- Ejercicio 13. Probar con SERIALIZABLE.
SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE;

START TRANSACTION;

SELECT * FROM cliente;

    -- Intentar actualización concurrente en otra sesión
    COMMIT;


-- Ejercicio 14. Operaciones DDL en transacciones.
START TRANSACTION;

CREATE TABLE historial(
    id INT PRIMARY KEY,
    operacion VARCHAR(50)
);

ROLLBACK;


-- Ejercicio 15. Verificar si la tabla historial existe.
SHOW TABLES;