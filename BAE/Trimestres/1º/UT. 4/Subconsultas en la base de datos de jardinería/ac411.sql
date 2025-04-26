/*Ejercicio 1.4.8*/
USE jardineria;


/*Apartado 1.4.8.1*/
/*Ej.1 - Devuelve el nombre del cliente con mayor límite de crédito*/
SELECT
    c.nombre_cliente AS Cliente, c.limite_credito AS "Limite de crédito"
FROM cliente c
where c.limite_credito = (
    SELECT
    MAX(c2.limite_credito)
    FROM cliente c2
);

/*Ej.2. - Devuelve el nombre del producto que tenga el precio de venta más caro*/
SELECT
    p.nombre AS Producto, p.precio_venta AS "Precio de Venta más Alto"
FROM producto p
where p.precio_venta = (
    SELECT
    MAX(p2.precio_venta)
    FROM producto p2
);

/*Ej.3. - Devuelve el nombre del producto del que se han vendido más unidades. (Tenga en cuenta que tendrá que calcular cuál es el número total de unidades que se han vendido de cada producto a partir de los datos de la tabla detalle_pedido)*/
SELECT p.nombre
FROM producto p
INNER JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto
WHERE dp.cantidad = (
    SELECT MAX(dp.cantidad)
    FROM detalle_pedido dp
);

/*Ej.4. - Los clientes cuyo límite de crédito sea mayor que los pagos que haya realizado. (Sin utilizar INNER JOIN)*/
SELECT c.nombre_cliente, c.limite_credito
FROM cliente c
WHERE c.limite_credito >= (
    SELECT SUM(total)
    FROM pago 
    WHERE codigo_cliente = c.codigo_cliente
    GROUP BY codigo_cliente
);

/*Ej.5. - Devuelve el producto que más unidades tiene en stock*/
SELECT p.nombre
FROM producto p
WHERE p.cantidad_en_stock = (
    SELECT MAX(p.cantidad_en_stock) 
    FROM producto p
);

/*Ej.6. - Devuelve el producto que menos unidades tiene en stock*/
SELECT p.nombre
FROM producto p
WHERE p.cantidad_en_stock = (
    SELECT MIN(p.cantidad_en_stock) 
    FROM producto p
);

/*Ej.7. - Devuelve el nombre, los apellidos y el email de los empleados que están a cargo de Alberto Soria*/
SELECT CONCAT(e.nombre, " ", e.apellido1, " ", e.apellido2) AS "Empleados a cargo de Alberto Soria"
FROM empleado e
WHERE e.codigo_jefe = (
    SELECT e.codigo_empleado 
    FROM empleado e
    WHERE e.nombre = "Alberto" AND e.apellido1 = "Soria"
);



/*Apartado 1.4.8.2*/
/*Ej.8. - Devuelve el nombre del cliente con mayor límite de crédito*/
SELECT c.nombre_cliente
FROM cliente c
WHERE c.limite_credito >= ALL(
    SELECT MAX(c.limite_credito) 
    FROM cliente c
);

/*Ej.9. -Devuelve el nombre del producto que tenga el precio de venta más caro*/
SELECT p.nombre
FROM producto p
WHERE p.precio_venta >= ALL(
    SELECT MAX(p.precio_venta)
    FROM producto p
);

/*Ej.10. - Devuelve el producto que menos unidades tiene en stock*/
SELECT p.nombre
FROM producto p
WHERE p.cantidad_en_stock <= ALL(
    SELECT MIN(p.cantidad_en_stock)
    FROM producto p
);

/*Apartado 1.4.8.3*/
/*Ej.11. - Devuelve el nombre, apellido1 y cargo de los empleados que no representen a ningún cliente*/
SELECT e.nombre, e.apellido1, e.apellido2
FROM empleado e
WHERE e.codigo_empleado NOT IN (
    SELECT c.codigo_empleado_rep_ventas
    FROM cliente c
);

/*Ej.12. - Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago*/
SELECT c.nombre_cliente
FROM cliente c
WHERE c.codigo_cliente NOT IN (
    SELECT p.codigo_cliente 
    FROM pago p
);

/*Ej.13. - Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago*/
SELECT c.nombre_cliente
FROM cliente c 
WHERE c.codigo_cliente IN (
    SELECT p.codigo_cliente 
    FROM pago p
);

/*Ej.14. - Devuelve un listado de los productos que nunca han aparecido en un pedido*/
SELECT p.nombre
FROM producto p
WHERE p.codigo_producto NOT IN (
    SELECT dp.codigo_producto 
    FROM detalle_pedido dp
);

/*Ej.15. - Devuelve el nombre, apellidos, puesto y teléfono de la oficina de aquellos empleados que no sean representante de ventas de ningún cliente*/
SELECT e.nombre, e.apellido1, e.apellido2, e.puesto, o.telefono
FROM empleado e INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
WHERE e.codigo_empleado NOT IN (
    SELECT c.codigo_empleado_rep_ventas 
    FROM cliente c
);

/*Ej.16. - Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales*/
SELECT o.codigo_oficina, o.ciudad, o.region, o.pais, o.codigo_postal, o.telefono, o.linea_direccion1, o.linea_direccion2
FROM oficina o
WHERE o.codigo_oficina NOT IN (
    SELECT DISTINCT o.codigo_oficina 
    FROM oficina o
        INNER JOIN empleado e USING(codigo_oficina)
        INNER JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
        INNER JOIN pedido pe USING(codigo_cliente)
        INNER JOIN detalle_pedido dp USING(codigo_pedido)
        INNER JOIN producto pr USING(codigo_producto)
    WHERE pr.gama = "Frutales"
);

/*Ej.17. - Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago*/
SELECT c.nombre_cliente
FROM cliente c 
WHERE c.codigo_cliente IN (
    SELECT p.codigo_cliente 
    FROM pedido p) AND c.codigo_cliente NOT IN (
        SELECT p.codigo_cliente
        FROM pago p
);



/*Apartado 1.4.8.4*/
/*Ej.18. - Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago*/
SELECT *
FROM cliente c
WHERE NOT EXISTS (
    SELECT *
    FROM pago p
    WHERE c.codigo_cliente = p.codigo_cliente
);

/*Ej.19. - Devuelve un listado que muestre solamente los clientes que sí han realizado algún pago*/
SELECT 
FROM cliente c
WHERE EXISTS (
    SELECT *
    FROM pago p
    WHERE c.codigo_cliente = p.codigo_cliente
);

/*Ej.20. - Devuelve un listado de los productos que nunca han aparecido en un pedido*/
SELECT * 
FROM cliente c
WHERE NOT EXISTS (
    SELECT * 
    FROM pedido p
    WHERE p.codigo_cliente = c.codigo_cliente
);

/*Ej.21. - Devuelve un listado de los productos que han aparecido en un pedido alguna vez*/
SELECT * 
FROM cliente c
WHERE EXISTS (
    SELECT * 
    FROM pedido p
    WHERE p.codigo_cliente = c.codigo_cliente
);