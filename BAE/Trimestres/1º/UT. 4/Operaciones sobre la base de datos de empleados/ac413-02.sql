/*(Apartado 7.2)*/


-- Ejercicio 1. Inserta un nuevo departamento indicando su código, nombre y presupuesto
INSERT INTO departamento (nombre, id, presupuesto, gastos)
VALUES ('Atención al cliente', 8, 37000, 0);

-- Ejercicio 2. Inserta un nuevo departamento indicando su nombre y presupuesto
INSERT INTO departamento (nombre, presupuesto, gastos)
VALUES ('Exámenes médicos', 51000, 0);

-- Ejercicio 3. Inserta un nuevo departamento indicando su código, nombre, presupuesto y gastos
INSERT INTO departamento (nombre, id, presupuesto, gastos)
VALUES ('Catering', 10, 3400, 2100);

-- Ejercicio 4. Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de inserción debe incluir: código, nif, nombre, apellido1, apellido2 y codigo_departamento
INSERT INTO empleado (nombre, id, nif, apellido1, apellido2, id_departamento)
VALUES ('Rodrigo', 14, '95519599R', 'López', 'Pérez', 8);

-- Ejercicio 5. Inserta un nuevo empleado asociado a uno de los nuevos departamentos. La sentencia de inserción debe incluir: nif, nombre, apellido1, apellido2 y codigo_departamento
INSERT INTO empleado (nombre, nif, apellido1, apellido2, id_departamento)
VALUES ('Matías Ariel', '35488130G', 'Zayas', 'Vera', 8);

-- Ejercicio 6. Crea una nueva tabla con el nombre departamento_backup que tenga las mismas columnas que la tabla departamento. Una vez creada copia todos las filas de tabla departamento en departamento_backup
CREATE TABLE departamento_backup(
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  presupuesto DOUBLE UNSIGNED NOT NULL,
  gastos DOUBLE UNSIGNED NOT NULL
);

-- Ejercicio 7. Elimina el departamento Proyectos. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
DELETE FROM departamento WHERE nombre  = "Proyectos";

-- Ejercicio 8. Elimina el departamento Desarrollo. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese posible borrarlo?
-- "Desarrollo" no es una columna de la tabla "departamento" por lo que primero debemos asignarle a los empleados cuyo "id" sea 1 en la columna de "id_departamento" un valor "NULL", nulo
UPDATE empleado SET id_departamento = NULL WHERE id_departamento = 1;
DELETE FROM departamento WHERE nombre  = "Desarrollo";

-- Ejercicio 9. Actualiza el código del departamento Recursos Humanos y asígnale el valor 30. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
-- Para este ejercicio necesitaremos modificar de antemano la clave foránea, para ello:
ALTER TABLE empleado drop foreign key empleado_ibfk_1; -- Eliminamos la clave foránea
-- Creas de nuevo la clave foránea
ALTER TABLE empleado ADD CONSTRAINT FK_departamento
FOREIGN KEY (id_departamento) REFERENCES departamento(id)
ON DELETE CASCADE
ON UPDATE CASCADE;
-- Haces la consulta/modificación necesaria en los valores del código del departamento "Recursos Humanos"
UPDATE departamento SET id = 30 WHERE nombre = "Recursos Humanos";

-- Ejercicio 10. Actualiza el código del departamento Publicidad y asígnale el valor 40. ¿Es posible actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese actualizarlo?
UPDATE departamento SET id = 40 WHERE nombre = "Publicidad";

-- Ejercicio 11. Actualiza el presupuesto de los departamentos sumándole 50000 € al valor del presupuesto actual, solamente a aquellos departamentos que tienen un presupuesto menor que 20000€
UPDATE departamento SET presupuesto = presupuesto + 50000 WHERE presupuesto < 20000;
