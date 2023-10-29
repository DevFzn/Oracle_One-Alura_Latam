USE empresa;

INSERT INTO facturas
SELECT numero, fecha_venta as fecha, dni, matricula, impuesto
FROM jugos_ventas.facturas;

INSERT INTO items
SELECT numero, codigo_del_producto AS codigo, cantidad, precio
FROM jugos_ventas.items_facturas;
