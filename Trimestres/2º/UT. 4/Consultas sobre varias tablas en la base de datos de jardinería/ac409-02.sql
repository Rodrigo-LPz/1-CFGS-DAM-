/*Apartado 1.4.5*/
/*Ej.1 - Obtén un listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas.*/
SELECT 
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM cliente c
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas);

/*Ej.2. - Muestra el nombre de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas.*/
SELECT DISTINCT
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM cliente c
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
INNER JOIN pago p ON (p.codigo_cliente = c.codigo_cliente);

/*Ej.3. - Muestra el nombre de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas.*/
SELECT
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM cliente c
LEFT JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
WHERE p.codigo_cliente IS NULL;

/*Ej.4. - Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.*/
SELECT DISTINCT
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    o.ciudad AS Ciudad
FROM cliente c
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
INNER JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
INNER JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina);

/*Ej.5. - Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.*/
SELECT 
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    o.ciudad AS Ciudad
FROM cliente c
LEFT JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
INNER JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina)
WHERE p.codigo_cliente IS NULL;

/*Ej.6. - Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.*/
SELECT DISTINCT
	o.linea_direccion1, 
    o.linea_direccion2
FROM cliente c
INNER JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
INNER JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina)
WHERE c.ciudad = 'Fuenlabrada';

/*Ej.7. - Devuelve el nombre de los clientes y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante.*/
SELECT 
	c.nombre_cliente AS Cliente, 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    o.ciudad AS Ciudad
FROM cliente c
INNER JOIN empleado e ON (e.codigo_empleado = c.codigo_empleado_rep_ventas)
INNER JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina);

/*Ej.8. - Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.*/
SELECT 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    CONCAT(j.nombre, ' ', j.apellido1, ' ',j.apellido2) AS Jefe
FROM empleado e
INNER JOIN empleado j ON (j.codigo_empleado = e.codigo_jefe);

/*Ej.9. - Devuelve un listado que muestre el nombre de cada empleados, el nombre de su jefe y el nombre del jefe de sus jefe.*/
SELECT 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    CONCAT(j.nombre, ' ', j.apellido1, ' ',j.apellido2) AS Jefe,
    CONCAT(s.nombre, ' ', s.apellido1, ' ',s.apellido2) AS "Jefe del jefe"
FROM empleado e
INNER JOIN empleado j ON (j.codigo_empleado = e.codigo_jefe)
INNER JOIN empleado s ON (s.codigo_empleado = j.codigo_jefe);

/*Ej.10. - Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.*/
SELECT 
	c.nombre_cliente AS Cliente,
    p.codigo_pedido AS Pedido
FROM cliente c 
INNER JOIN pedido p ON (p.codigo_cliente = c.codigo_cliente)
WHERE p.fecha_entrega > p.fecha_esperada;

/*Ej.11. - Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.*/
SELECT DISTINCT
	c.nombre_cliente,
    pro.gama
FROM cliente c 
INNER JOIN pedido p ON (p.codigo_cliente = c.codigo_cliente)
INNER JOIN detalle_pedido d ON (d.codigo_pedido = p.codigo_pedido)
INNER JOIN producto pro ON (pro.codigo_producto = d.codigo_producto);



/*Apartado 1.4.6*/
/*Ej.1. - Devuelve un listado que muestre solamente los clientes que no han realizado ningún pago.*/
SELECT 
	c.nombre_cliente AS Cliente
FROM cliente c
LEFT JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
WHERE p.codigo_cliente IS NULL;

/*Ej.2. -Devuelve un listado que muestre solamente los clientes que no han realizado ningún pedido.*/
SELECT 
	c.nombre_cliente AS Cliente
FROM cliente c
LEFT JOIN pedido p ON (p.codigo_cliente = c.codigo_cliente)
WHERE p.codigo_cliente IS NULL;

/*Ej.3. - Devuelve un listado que muestre los clientes que no han realizado ningún pago y los que no han realizado ningún pedido.*/
SELECT 
	c.nombre_cliente AS Cliente
FROM pedido p
RIGHT JOIN cliente c ON (c.codigo_cliente = p.codigo_cliente)
LEFT JOIN pago pg ON (pg.codigo_cliente = c.codigo_cliente)
WHERE p.codigo_cliente IS NULL AND pg.codigo_cliente IS NULL;

/*Ej.4. - Devuelve un listado que muestre solamente los empleados que no tienen una oficina asociada.*/
SELECT 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM empleado e 
LEFT JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina)
WHERE e.codigo_oficina IS NULL;

/*Ej.5. - Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado.*/
SELECT 
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM empleado e 
LEFT JOIN cliente c ON (c.codigo_empleado_rep_ventas = e.codigo_empleado)
WHERE c.codigo_empleado_rep_ventas IS NULL;

/*Ej.6. - Devuelve un listado que muestre solamente los empleados que no tienen un cliente asociado junto con los datos de la oficina donde trabajan.*/
SELECT DISTINCT
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    o.codigo_oficina AS Oficina
FROM empleado e 
LEFT JOIN cliente c ON (c.codigo_empleado_rep_ventas = e.codigo_empleado)
INNER JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina)
WHERE c.codigo_empleado_rep_ventas IS NULL;

/*Ej.7. - Devuelve un listado que muestre los empleados que no tienen una oficina asociada y los que no tienen un cliente asociado.*/
SELECT DISTINCT
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado
FROM empleado e 
LEFT JOIN cliente c ON (c.codigo_empleado_rep_ventas = e.codigo_empleado)
LEFT JOIN oficina o ON (o.codigo_oficina = e.codigo_oficina)
WHERE e.codigo_oficina IS NULL or c.codigo_empleado_rep_ventas IS NULL;

/*Ej.8. - Devuelve un listado de los productos que nunca han aparecido en un pedido.*/
SELECT 
	pro.nombre
FROM producto pro
LEFT JOIN detalle_pedido d ON (d.codigo_producto = pro.codigo_producto)
LEFT JOIN pedido p ON (p.codigo_pedido = d.codigo_pedido)
WHERE d.codigo_producto IS NULL;

/*Ej.9. - Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.*/
SELECT 
	pro.nombre,
    pro.descripcion,
    p.comentarios
FROM producto pro
LEFT JOIN detalle_pedido d ON (d.codigo_producto = pro.codigo_producto)
LEFT JOIN pedido p ON (p.codigo_pedido = d.codigo_pedido)
WHERE d.codigo_producto IS NULL;

/*Ej.10. - Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan sido los representantes de ventas de algún cliente que haya realizado la compra de algún producto de la gama Frutales.*/
SELECT 
	o.codigo_oficina,
    o.pais
FROM oficina o
WHERE o.codigo_oficina NOT IN (SELECT DISTINCT ofi.codigo_oficina
                               FROM oficina ofi
                               INNER JOIN empleado e using(codigo_oficina)
                               INNER JOIN cliente c ON c.codigo_empleado_rep_ventas = e.codigo_empleado
                               INNER JOIN pedido p using(codigo_cliente)
                               INNER JOIN detalle_pedido d using(codigo_pedido)
                               INNER JOIN producto pro using(codigo_producto)
                               WHERE pro.gama = 'Frutales');

/*Ej.11. - Devuelve un listado con los clientes que han realizado algún pedido pero no han realizado ningún pago.*/
SELECT DISTINCT
	c.codigo_cliente AS Código,
    c.nombre_cliente AS Cliente
FROM cliente c
INNER JOIN pedido p using(codigo_cliente)
LEFT JOIN pago pa ON (pa.codigo_cliente = c.codigo_cliente)
WHERE pa.codigo_cliente IS NULL;

/*Ej.12. - Devuelve un listado con los datos de los empleados que no tienen clientes asociados y el nombre de su jefe asociado.*/
SELECT 
	e.codigo_empleado AS 'Código de Empleado',
	CONCAT(e.nombre, ' ', e.apellido1, ' ', e.apellido2) AS Empleado,
    e.email AS Email,
    e.puesto AS Puesto,
    CONCAT(j.nombre, ' ', j.apellido1, ' ',j.apellido2) AS Jefe
FROM empleado e
LEFT JOIN cliente c ON (c.codigo_empleado_rep_ventas = e.codigo_empleado)
INNER JOIN empleado j ON (j.codigo_empleado = e.codigo_jefe)
WHERE c.codigo_empleado_rep_ventas IS NULL;