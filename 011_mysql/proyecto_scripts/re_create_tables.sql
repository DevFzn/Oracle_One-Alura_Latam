USE empresa;

DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS facturas;

CREATE TABLE facturas (
    numero INT NOT NULL,
    fecha DATE,
    dni VARCHAR(11) NOT NULL,
    matricula VARCHAR(5) NOT NULL,
    impuesto FLOAT,
    PRIMARY KEY (numero),
    FOREIGN KEY (dni) REFERENCES clientes(dni),
    FOREIGN KEY (matricula) REFERENCES vendedores(matricula)
);

CREATE TABLE items (
    numero INT NOT NULL,
    codigo VARCHAR(10) NOT NULL,
    cantidad INT,
    precio FLOAT,
    PRIMARY KEY (numero, codigo),
    FOREIGN KEY (numero) REFERENCES facturas(numero),
    FOREIGN KEY (codigo) REFERENCES productos(codigo)
);

INSERT INTO facturas
SELECT numero, fecha_venta as fecha, dni, matricula, impuesto
FROM jugos_ventas.facturas;

INSERT INTO items
SELECT numero, codigo_del_producto AS codigo, cantidad, precio
FROM jugos_ventas.items_facturas;
