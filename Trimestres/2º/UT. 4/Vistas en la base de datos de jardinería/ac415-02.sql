/*Ejercicio 1.9*/
USE jardineria;


/*Apartado 1.9.1*/
/*Ej.1 - Escriba una vista que se llame listado_pagos_clientes que muestre un listado donde aparezcan todos los clientes y los pagos que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: nombre y apellidos del cliente concatenados, teléfono, ciudad, pais, fecha_pago, total del pago, id de la transacción*/
CREATE VIEW listado_pagos_clientes AS
	SELECT
		CONCAT(c.nombre_contacto, " ", c.apellido_contacto) AS cliente,
        c.telefono,
        c.ciudad,
        c.pais,
        p.fecha_pago,
        p.total,
        p.id_transaccion
	FROM cliente c
		INNER JOIN pago p ON (p.codigo_cliente = c.codigo_cliente)
        ORDER BY cliente ASC;

/*Ej.2. - Escriba una vista que se llame listado_pedidos_clientes que muestre un listado donde aparezcan todos los clientes y los pedidos que ha realizado cada uno de ellos. La vista deberá tener las siguientes columnas: código del cliente, nombre y apellidos del cliente concatendados, teléfono, ciudad, pais, código del pedido, fecha del pedido, fecha esperada, fecha de entrega y la cantidad total del pedido, que será la suma del producto de todas las cantidades por el precio de cada unidad, que aparecen en cada línea de pedido*/
CREATE VIEW listado_pedidos_clientes AS
    SELECT
		c.codigo_cliente,
        CONCAT(c.nombre_contacto, " ", c.apellido_contacto) AS cliente,
        c.telefono,
        c.ciudad,
        c.pais,
        pe.codigo_pedido,
        pe.fecha_pedido,
        pe.fecha_esperada,
        pe.fecha_entrega,
        sum(dp.cantidad* coalesce(dp.precio_unidad, 0)) AS total
	FROM cliente c
		LEFT JOIN pedido pe ON (pe.codigo_cliente = c.codigo_cliente)
        LEFT JOIN detalle_pedido dp ON (dp.codigo_pedido = pe.codigo_pedido)
	GROUP BY c.codigo_cliente, c.nombre_contacto, c.apellido_contacto, c.telefono, c.ciudad, c.pais, pe.codigo_pedido, pe.fecha_pedido, pe.fecha_esperada, pe.fecha_entrega
    ORDER BY c.codigo_cliente ASC;

/*Ej.3. - Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes de la ciudad de Madrid que han realizado pagos*/
SELECT * FROM listado_pagos_clientes WHERE ciudad = "Madrid";

/*Ej.4. - Utilice las vistas que ha creado en los pasos anteriores para devolver un listado de los clientes que todavía no han recibido su pedido*/
SELECT * FROM listado_pedidos_clientes WHERE fecha_entrega IS NULL;


/*Ej.5. - Utilice las vistas que ha creado en los pasos anteriores para calcular el número de pedidos que se ha realizado cada uno de los clientes*/
SELECT *, count(codigo_pedido) AS numero_pedidos FROM listado_pedidos_clientes GROUP BY codigo_cliente;

/*Ej.6. - Utilice las vistas que ha creado en los pasos anteriores para calcular el valor del pedido máximo y mínimo que ha realizado cada cliente*/
SELECT *, max(total) AS maximo, min(total) AS minimo FROM listado_pagos_clientes GROUP BY cliente;

/*Ej.7. - Modifique el nombre de las vista listado_pagos_clientes y asígnele el nombre listado_de_pagos. Una vez que haya modificado el nombre de la vista ejecute una consulta utilizando el nuevo nombre de la vista para comprobar que sigue funcionando correctamente*/
RENAME table listado_pagos_clientes TO listado_de_pagos; SELECT * FROM listado_de_pagos;


/*Ej.8. - Elimine las vistas que ha creado en los pasos anteriores*/
DROP VIEW listado_de_pagos;
DROP VIEW listado_pedidos_clientes;