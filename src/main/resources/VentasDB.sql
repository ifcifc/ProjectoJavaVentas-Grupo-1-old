CREATE TABLE articulo (
    id_articulo INTEGER PRIMARY KEY AUTOINCREMENT,
    cod INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    descripcion TEXT,
    precio REAL NOT NULL,
    isDelete BOOLEAN DEFAULT false
);

CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    isEmpleado BOOLEAN NOT NULL,
    isDelete BOOLEAN DEFAULT false
);

CREATE TABLE stock (
    id_stock INTEGER PRIMARY KEY AUTOINCREMENT,
    id_articulo INTEGER NOT NULL,
    cantidad INTEGER NOT NULL,
    isDelete BOOLEAN DEFAULT false,
    FOREIGN KEY (id_articulo) REFERENCES articulo(id_articulo)
);

CREATE TABLE carrito (
    id_carrito INTEGER PRIMARY KEY AUTOINCREMENT,
    id_usuario INTEGER NOT NULL,
    id_articulo INTEGER NOT NULL,
    isDelete BOOLEAN DEFAULT false,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_articulo) REFERENCES articulo(id_articulo)
);



CREATE TABLE venta (
	id_venta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    id_usuario INTEGER NOT NULL,
	fecha TEXT NOT NULL,
	monto NUMERIC(8,4) NOT NULL,
    isDelete BOOLEAN DEFAULT false,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);


CREATE TABLE venta_articulo(
    id_venta_articulo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    id_venta INTEGER NOT NULL,
    id_articulo INTEGER NOT NULL,
	monto NUMERIC(8,4) NOT NULL,
    isDelete BOOLEAN DEFAULT false,
    FOREIGN KEY (id_articulo) REFERENCES articulo(id_articulo),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
);

CREATE TABLE movimiento (
	id_movimiento INTEGER PRIMARY KEY AUTOINCREMENT,
	id_usuario INTEGER NOT NULL,
	monto NUMERIC(8,4) NOT NULL,
	id_usuario_to INTEGER,
	id_venta INTEGER,
	fecha TEXT NOT NULL,
    isDelete BOOLEAN DEFAULT false,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_usuario_to) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
);