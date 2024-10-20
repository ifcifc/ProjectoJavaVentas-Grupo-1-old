-- usuario definition

CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    isEmpleado BOOLEAN NOT NULL,
    isDelete BOOLEAN DEFAULT false
);

-- articulo definition

CREATE TABLE articulo (
    id_articulo INTEGER PRIMARY KEY AUTOINCREMENT,
    cod INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    descripcion TEXT,
    precio REAL NOT NULL,
    isDelete BOOLEAN DEFAULT false
);

-- stock definition

CREATE TABLE stock (
	id_stock INTEGER PRIMARY KEY AUTOINCREMENT,
	id_articulo INTEGER NOT NULL,
	cantidad INTEGER NOT NULL,
	isDelete BOOLEAN DEFAULT (false),
	CONSTRAINT STOCK_PK PRIMARY KEY (id_stock)
);

-- carrito definition

CREATE TABLE carrito (
	id_carrito INTEGER PRIMARY KEY AUTOINCREMENT,
	id_usuario INTEGER NOT NULL,
	id_articulo INTEGER NOT NULL,
	isComprado BOOLEAN NOT NULL,
	isDelete BOOLEAN DEFAULT (false),
	CONSTRAINT CARRITO_PK PRIMARY KEY (id_carrito)
);