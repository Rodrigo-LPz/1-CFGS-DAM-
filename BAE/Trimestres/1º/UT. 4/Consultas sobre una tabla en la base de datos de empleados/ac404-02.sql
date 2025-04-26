Ejercicio 1:
SELECT apellido1 FROM empleado;

Ejercicio 2:
SELECT DISTINCT apellido1 FROM empleado;

Ejercicio 3:
SELECT * FROM empleado;

Ejercicio 4:
SELECT nombre, apellido1, apellido2 FROM empleado;

Ejercicio 5:
SELECT id_departamento FROM empleado;

Ejercicio 6:
SELECT DISTINCT id_departamento FROM empleado;

Ejercicio 7:
SELECT CONCAT (nombre, " ", apellido1, " ", apellido2) AS "Nombre completo" FROM empleado;

Ejercicio 8:
SELECT UPPER(CONCAT (nombre, " ", apellido1, " ", apellido2)) AS "Nombre completo" FROM empleado;

Ejercicio 9:
SELECT LOWER(CONCAT (nombre, " ", apellido1, " ", apellido2)) AS "Nombre completo" FROM empleado;

Ejercicio 10:
SELECT SUBSTRING(nif, 1,8) AS "Num_nif", SUBSTRING(nif, 9,9) AS "Nom_nif" FROM empleado;

Ejercicio 11:
SELECT nombre, (presupuesto-gastos) AS "presupuesto_actual" FROM departamento;

Ejercicio 12:
SELECT nombre, (presupuesto-gastos) AS "presupuesto_actual" FROM departamento
	ORDER BY presupuesto-gastos ASC;

Ejercicio 13:
SELECT nombre FROM departamento
	ORDER BY nombre ASC;

Ejercicio 14:
SELECT nombre FROM departamento
	ORDER BY nombre DESC;

Ejercicio 15:
SELECT CONCAT (apellido2, " ", apellido1, " ", nombre) FROM empleado
	ORDER BY (apellido2) ASC, (apellido1) ASC, (nombre) ASC;

Ejercicio 16:
SELECT nombre, presupuesto FROM departamento
	ORDER BY presupuesto DESC LIMIT 3;

Ejercicio 17:
SELECT nombre, presupuesto FROM departamento
	ORDER BY presupuesto ASC LIMIT 3;

Ejercicio 18:
SELECT nombre, gastos FROM departamento
	ORDER BY gastos DESC LIMIT 2;

Ejercicio 19:
SELECT nombre, gastos FROM departamento
	ORDER BY gastos ASC LIMIT 2;

Ejercicio 20:
SELECT * FROM empleado LIMIT 2, 5;

Ejercicio 21:
SELECT nombre, presupuesto FROM departamento
	WHERE presupuesto=>15000;

Ejercicio 22:
SELECT nombre, gastos FROM departamento
	WHERE gastos < 5000;

Ejercicio 23:
SELECT nombre, presupuesto FROM departamento
	WHERE presupuesto >= 100000 AND presupuesto <= 200000;

Ejercicio 24:
SELECT nombre, presupuesto FROM departamento
	WHERE NOT (presupuesto >= 100000 AND presupuesto <= 200000);

Ejercicio 25:
SELECT nombre, presupuesto FROM departamento
	WHERE presupuesto BETWEEN 100000 AND 200000;

Ejercicio 26:
SELECT nombre, presupuesto FROM departamento
	WHERE NOT presupuesto BETWEEN 100000 AND 200000;

Ejercicio 27:
SELECT nombre, gastos, presupuesto FROM departamento
	WHERE gastos > presupuesto;

Ejercicio 28:
SELECT nombre, gastos, presupuesto FROM departamento
	WHERE gastos < presupuesto;

Ejercicio 29:
SELECT nombre, gastos, presupuesto FROM departamento
	WHERE gastos = presupuesto;

Ejercicio 30:
SELECT * FROM empleado
	WHERE apellido2 IS NULL;

Ejercicio 31:
SELECT * FROM empleado
	WHERE apellido2 IS NOT NULL;

Ejercicio 32:
SELECT * FROM empleado
	WHERE apellido2 = "López";

Ejercicio 33:
SELECT * FROM empleado
	WHERE apellido2 = "Díaz" OR apellido2 = "Moreno";

Ejercicio 34:
SELECT * FROM empleado
	WHERE apellido2 IN ("Díaz", "Moreno");

Ejercicio 35:
SELECT nombre, apellido1, apellido2, nif FROM empleado
	WHERE id_departamento = 3 ;

Ejercicio 36:
SELECT nombre, apellido1, apellido2, nif FROM empleado
	WHERE id_departamento IN (2, 4, 5);