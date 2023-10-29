USE empresa;

/*
    MySQL
    SET GLOBAL log_bin_trust_function_creators = 1
*/

DROP FUNCTION IF EXISTS f_aleatorio;
DELIMITER $$
CREATE FUNCTION f_aleatorio(min INT, max INT)
RETURNS INT
BEGIN
    DECLARE vresultado INT;
    SELECT FLOOR(RAND() * (MAX-MIN+1)+MIN) INTO vresultado;
    RETURN vresultado;
END $$
DELIMITER ;


DROP FUNCTION IF EXISTS f_cliente_aleatorio;
DELIMITER $$
CREATE FUNCTION f_cliente_aleatorio()
RETURNS VARCHAR(11)
BEGIN
    DECLARE vresultado VARCHAR(11);
    DECLARE vmax, vrand INT;
    SELECT COUNT(*) INTO vmax FROM clientes;
    SET vrand = f_aleatorio(1, vmax);
    SET vrand = vrand-1;
    SELECT dni INTO vresultado FROM clientes LIMIT vrand, 1;
    RETURN vresultado;
END $$
DELIMITER ;


DROP FUNCTION IF EXISTS f_producto_aleatorio;
DELIMITER $$
CREATE FUNCTION f_producto_aleatorio()
RETURNS VARCHAR(11)
BEGIN
    DECLARE vresultado VARCHAR(11);
    DECLARE vmax, vrand INT;
    SELECT COUNT(*) INTO vmax FROM productos;
    SET vrand = f_aleatorio(1, vmax);
    SET vrand = vrand-1;
    SELECT codigo INTO vresultado FROM productos LIMIT vrand, 1;
    RETURN vresultado;
END $$
DELIMITER ;


DROP FUNCTION IF EXISTS f_vendedor_aleatorio;
DELIMITER $$
CREATE FUNCTION f_vendedor_aleatorio()
RETURNS VARCHAR(11)
BEGIN
    DECLARE vresultado VARCHAR(11);
    DECLARE vmax, vrand INT;
    SELECT COUNT(*) INTO vmax FROM vendedores;
    SET vrand = f_aleatorio(1, vmax);
    SET vrand = vrand-1;
    SELECT matricula INTO vresultado FROM vendedores LIMIT vrand, 1;
    RETURN vresultado;
END $$
DELIMITER ;


SELECT "Test Funciones aleatorias" AS '';
SELECT f_cliente_aleatorio() AS cliente,
       f_producto_aleatorio() AS producto,
       f_vendedor_aleatorio() AS vendedor;


DROP PROCEDURE IF EXISTS sp_venta;
DELIMITER $$
CREATE PROCEDURE sp_venta(fecha DATE, max_items INT, max_cantidad INT)
BEGIN
    DECLARE vcliente VARCHAR(11);
    DECLARE vproducto VARCHAR(10);
    DECLARE vvendedor VARCHAR(5);
    DECLARE vcantidad INT;
    DECLARE vprecio FLOAT;
    DECLARE vitems INT;
    DECLARE vnfactura INT;
    DECLARE vcontador INT DEFAULT 1;
    DECLARE vitem_repetido INT;
    SELECT MAX(numero)+1 INTO vnfactura FROM facturas;
    SET vcliente = f_cliente_aleatorio();
    SET vvendedor = f_vendedor_aleatorio();
    INSERT INTO facturas (numero, fecha, dni, matricula, impuesto)
        VALUES (vnfactura, fecha, vcliente, vvendedor, 0.16);
    SET vitems = f_aleatorio(1, max_items);
    WHILE vcontador <= vitems DO
        SET vproducto = f_producto_aleatorio();
        SET vcantidad = f_aleatorio(1,max_cantidad);
        SELECT COUNT(*) INTO vitem_repetido FROM items
        WHERE codigo = vproducto AND numero = vnfactura;
        IF vitem_repetido = 0 THEN
            SELECT precio INTO vprecio FROM productos WHERE codigo = vproducto;
            INSERT INTO items(numero, codigo, cantidad, precio)
                VALUES(vnfactura, vproducto, vcantidad, vprecio);
            SET vcontador = vcontador+1;
        ELSE 
            SELECT precio INTO vprecio FROM productos WHERE codigo = vproducto;
            UPDATE items SET cantidad = ((SELECT cantidad FROM items
                WHERE codigo=vproducto AND numero=vnfactura) + vcantidad)
            WHERE codigo=vproducto AND numero=vnfactura;
            SET vcontador = vcontador+1;
        END IF;
    END WHILE;
END $$
DELIMITER ;

/*
    SP Venta Mentor

DELIMITER $$

CREATE PROCEDURE `sp_venta`(fecha DATE, maxitems INT, maxcantidad INT)
BEGIN
    DECLARE vcliente VARCHAR(11);
    DECLARE vproducto VARCHAR(10);
    DECLARE vvendedor VARCHAR(5);
    DECLARE vcantidad INT;
    DECLARE vprecio FLOAT;
    DECLARE vitens INT;
    DECLARE vnfactura INT;
    DECLARE vcontador INT DEFAULT 1;
    DECLARE vnumitems INT;
    SELECT MAX(NUMERO) + 1 INTO vnfactura FROM facturas;
    SET vcliente = f_cliente_aleatorio();
    SET vvendedor = f_vendedor_aleatorio();
    INSERT INTO facturas (NUMERO, FECHA, DNI, MATRICULA, IMPUESTO)
        VALUES (vnfactura, fecha, vcliente, vvendedor, 0.16);
    SET vitens = f_aleatorio(1,  maxitems);
    WHILE vcontador <= vitens
        DO
        SET vproducto = f_producto_aleatorio();
        SELECT COUNT(*) INTO vnumitems FROM items
        WHERE CODIGO = vproducto AND NUMERO = vnfactura;
        IF vnumitems = 0 THEN
          SET vcantidad = f_aleatorio(1, maxcantidad);
          SELECT PRECIO INTO vprecio FROM productos WHERE CODIGO = vproducto;
          INSERT INTO items(NUMERO, CODIGO, CANTIDAD, PRECIO) VALUES(vnfactura, vproducto, vcantidad, vprecio);
        END IF;
        SET vcontador = vcontador+1;
    END WHILE;
END $$

DELIMITER ;
*/
