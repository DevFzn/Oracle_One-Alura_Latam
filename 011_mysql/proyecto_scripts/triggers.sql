DROP PROCEDURE IF EXISTS sp_triggers;

DELIMITER $$
CREATE PROCEDURE sp_triggers()
BEGIN
    DELETE FROM facturacion;
    INSERT INTO facturacion
    SELECT A.fecha, SUM(B.cantidad * B.precio) AS VENTA_TOTAL
    FROM facturas A
    INNER JOIN
    items B
    ON A.numero = B.numero
    GROUP BY A.fecha;
END $$

DROP TRIGGER tg_facturacion_insert $$
DROP TRIGGER tg_facturacion_delete $$
DROP TRIGGER tg_facturacion_update $$

CREATE TRIGGER tg_facturacion_insert
AFTER INSERT ON items
FOR EACH ROW BEGIN
    CALL sp_triggers;
END $$

CREATE TRIGGER tg_facturacion_delete
AFTER DELETE ON items
FOR EACH ROW BEGIN
    CALL sp_triggers;
END $$

CREATE TRIGGER tg_facturacion_update
AFTER UPDATE ON items
FOR EACH ROW BEGIN
    CALL sp_triggers;
END $$

DELIMITER ;
