-- Ejercicio 1
SELECT COUNT(*) FROM pedido;

-- Ejercicio 2
SELECT AVG(id) FROM pedido;

-- Ejercicio 3
SELECT COUNT(DISTINCT id_comercial) FROM pedido;

-- Ejercicio 4
SELECT COUNT(*) FROM cliente;

-- Ejercicio 5
SELECT MAX(*) FROM periodo;

-- Ejercicio 6
SELECT MIN(total) FROM pedido;

-- Ejercicio 7
SELECT ciudad, MAX(categoria) FROM cliente
GROUP BY ciudad;

-- Ejercicio 8
SELECT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, pedido.fecha, MAX(pedido.total) AS "Máximo valor" FROM pedido INNER JOIN cliente ON pedido.id_cliente = cliente.id
GROUP BY fecha
ORDER BY id, fecha;

-- Ejercicio 9
SELECT pedido.fecha, MAX(pedido.total) AS "Valor" FROM pedido INNER JOIN cliente ON cliente.id = pedido.id_cliente
GROUP BY fecha
HAVING Valor > 2000;

-- Ejercicio 10
SELECT comercial.id, comercial.nombre, comercial.apellido1, comercial.apellido2, MAX(pedido.total) AS "Total" FROM comercial INNER JOIN pedido ON pedido.id_comercial = comercial.id
WHERE fecha = "2016-08-17"
GROUP BY id;

-- Ejercicio 11
SELECT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, COUNT(pedido.id) AS "Cantidad de pedidos" FROM cliente LEFT JOIN pedido ON cliente.id = pedido.id_cliente
GROUP BY id;

-- Ejercicio 12
SELECT cliente.id, cliente.nombre, cliente.apellido1, cliente.apellido2, COUNT(pedido.id_cliente) AS "Cantidad de pedidos" FROM pedido INNER JOIN cliente ON cliente.id = pedido.id_cliente
WHERE YEAR(fecha) = "2017"
GROUP BY id;

-- Ejercicio 13
SELECT cliente.id, cliente.nombre, cliente.apellido1, IFNULL(MAX(pedido.total), 0) AS "Valor" FROM cliente LEFT JOIN pedido ON cliente.id = pedido.id_cliente
GROUP BY id;

-- Ejercicio 14
SELECT YEAR(fecha) AS "Año", MAX(total) as "Total" FROM pedido
GROUP BY Año;

-- Ejercicio 15
SELECT YEAR(fecha) AS "Año", COUNT(*) AS "Cantidad de pedidos" FROM pedido
GROUP BY Año;