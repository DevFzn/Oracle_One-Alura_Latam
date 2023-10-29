USE empresa;

CREATE TABLE IF NOT EXISTS clientes (
    dni VARCHAR(11) NOT NULL,
    nombre VARCHAR(100) NULL,
    direccion VARCHAR(150),
    barrio VARCHAR(50),
    ciudad VARCHAR(50),
    estado VARCHAR(20),
    cp VARCHAR(10),
    fecha_nacimiento DATE,
    edad SMALLINT,
    sexo VARCHAR(1),
    limite_credito FLOAT,
    volumen_compra FLOAT,
    primera_compra BIT,
    PRIMARY KEY (dni)
);

CREATE TABLE IF NOT EXISTS vendedores (
    matricula VARCHAR(5) NOT NULL,
    nombre VARCHAR(100),
    barrio VARCHAR(50),
    comision float,
    fecha_admision DATE,
    vacaciones BIT(1),
    PRIMARY KEY (matricula)
);

CREATE TABLE IF NOT EXISTS productos (
    codigo VARCHAR(10) NOT NULL,
    descripcion VARCHAR(100),
    sabor VARCHAR(50),
    tamano VARCHAR(50),
    envase VARCHAR(50),
    precio FLOAT,
    PRIMARY KEY (codigo)
);

CREATE TABLE IF NOT EXISTS facturas (
    numero VARCHAR(5) NOT NULL,
    fecha DATE,
    dni VARCHAR(11) NOT NULL,
    matricula VARCHAR(5) NOT NULL,
    impuesto FLOAT,
    PRIMARY KEY (numero),
    FOREIGN KEY (dni) REFERENCES clientes(dni),
    FOREIGN KEY (matricula) REFERENCES vendedores(matricula)
);

CREATE TABLE IF NOT EXISTS items (
    numero VARCHAR(5) NOT NULL,
    codigo VARCHAR(10) NOT NULL,
    cantidad INT,
    precio FLOAT,
    PRIMARY KEY (numero, codigo),
    FOREIGN KEY (numero) REFERENCES facturas(numero),
    FOREIGN KEY (codigo) REFERENCES productos(codigo)
);
