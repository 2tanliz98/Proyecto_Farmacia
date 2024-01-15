-- Autora Tania Lizeth Peñaloza Lugo 07/09/2023
DROP USER IF EXISTS 'tania'@'localhost';
CREATE USER 'tania'@'localhost' IDENTIFIED BY 'tania';


DROP DATABASE if EXISTS farmacia;
CREATE DATABASE farmacia;

GRANT ALL PRIVILEGES ON farmacia.* TO 'tania'@'localhost';

USE farmacia;


CREATE TABLE empresa(
    id_empresa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL
);

CREATE TABLE articulo (
	id_articulo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	marca VARCHAR(50) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(300) NULL,
	precio NUMERIC(8,2) NOT NULL,
	articulo_tipo INT NOT NULL,
	unidades INT NOT NULL DEFAULT 0,
   imagen VARCHAR(40) NOT NULL,
   empresa INT NOT NULL,
	CONSTRAINT marca_nombre_uq UNIQUE (marca,nombre),
	CONSTRAINT precio_ck CHECK  (precio >= 0.0),
	CONSTRAINT unidades_ck CHECK (unidades>=0),
	CONSTRAINT articulo_empresa_fk FOREIGN KEY (empresa) REFERENCES farmacia.empresa(id_empresa) ON DELETE CASCADE
 );


CREATE TABLE rol(
    id_rol INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE permiso(
    id_permiso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE rol_permiso(
    id_rolpermiso INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    permiso INT  NOT NULL,
    rol INT  NOT NULL,
	CONSTRAINT rolPermiso_permiso_fk FOREIGN KEY (permiso) REFERENCES farmacia.permiso(id_permiso),
	CONSTRAINT rolPermiso_rol_fk FOREIGN KEY (rol) REFERENCES farmacia.rol(id_rol)
);


CREATE TABLE usuario(
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	ap_pat VARCHAR(50) NOT NULL,
	ap_mat VARCHAR(50)  NULL,
	alias VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	telefono VARCHAR(10) NOT NULL,
	-- direccion INT  NOT NULL,
	contrasenia VARCHAR(150) NOT NULL,
   rol INT  NOT NULL,
	CONSTRAINT email_uq UNIQUE (email)
	-- CONSTRAINT usuario_direccion_fk FOREIGN KEY (direccion) REFERENCES farmacia.direccion(gen_val)
);


CREATE TABLE direccion(
	gen_val INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	calle VARCHAR(50) NOT NULL,
	numero VARCHAR(6) NOT NULL,
	codigo_postal VARCHAR(5) NOT NULL,
	colonia VARCHAR(50) NOT NULL,
	municipio VARCHAR(50)  NULL,
	entidad_federativa VARCHAR(50) NOT NULL,
	usuario INT NOT NULL,
	CONSTRAINT usuario_direccion_fk FOREIGN KEY (usuario) REFERENCES farmacia.usuario(id_usuario)
	-- CONSTRAINT calle_cp_colonia_uq UNIQUE (calle, codigo_postal, colonia)
);


CREATE TABLE metodo_pago(
	id_metodo_pago INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(50) NOT NULL
);

CREATE TABLE tarjeta(
   id_tarjeta INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	usuario INT NOT NULL,
	numero_tarjeta VARCHAR(16) NOT NULL,
	fecha_expiracion DATE NOT NULL,
	tipo_tarjeta VARCHAR(50) NOT NULL,
	CONSTRAINT usuario_fk FOREIGN KEY (usuario) REFERENCES farmacia.usuario(id_usuario),
	CONSTRAINT numero_tarjeta_usuario_uq UNIQUE (numero_tarjeta),
	CONSTRAINT numero_tarjeta_ck CHECK (CHAR_LENGTH(CAST(numero_tarjeta AS CHAR)) = 16 )
);


CREATE TABLE pedido(
	id_pedido INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	metodo_pago INT NOT NULL,
	fecha DATE NOT NULL,
	usuario INT NOT NULL,
	total DECIMAL(10, 2) NOT NULL DEFAULT 0 CHECK (total >= 0),
	CONSTRAINT metodo_pago_fk FOREIGN KEY (metodo_pago) REFERENCES farmacia.metodo_pago(id_metodo_pago),
	CONSTRAINT usuario_pedido_fk FOREIGN KEY (usuario) REFERENCES farmacia.usuario(id_usuario)
);

CREATE TABLE detalle_compra(
	pedido INT NOT NULL,
	articulo INT NOT NULL,
	suma_total DECIMAL(8,2) NOT NULL DEFAULT 0 CHECK (suma_total >= 0),
	cantidad INT NOT NULL DEFAULT 0 CHECK (cantidad >= 0),
	CONSTRAINT cantidad_pp_ck CHECK (cantidad >= 0),
	CONSTRAINT pedido_pp_fk FOREIGN KEY (pedido) REFERENCES farmacia.pedido(id_pedido),
	CONSTRAINT articulo_pp_fk FOREIGN KEY (articulo) REFERENCES farmacia.articulo(id_articulo),
	CONSTRAINT detalle_compra_id PRIMARY KEY (pedido, articulo)
);


CREATE TABLE cat_cosmeticos (
   id_articulo INT NOT NULL PRIMARY KEY,
   tono_color VARCHAR(50) NOT NULL,
	CONSTRAINT articulo_cosmetico_fk FOREIGN KEY (id_articulo) REFERENCES farmacia.articulo(id_articulo) ON DELETE CASCADE
);


CREATE TABLE cat_farmacos (
   id_articulo INT NOT NULL  PRIMARY KEY,
	ingrediente_activo VARCHAR(80)  NULL,	
	CONSTRAINT articulo_farmaco_fk FOREIGN KEY (id_articulo) REFERENCES farmacia.articulo(id_articulo) ON DELETE CASCADE
);


CREATE TABLE estatus (
	id_estatus INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(50) NOT NULL,
   CONSTRAINT nombre_estatus_uq UNIQUE (nombre) 
);

CREATE TABLE historico_estatus_pedido(
	pedido INT NOT NULL,
	estatus INT NOT NULL,
	fecha DATE NOT NULL,
	CONSTRAINT pedido_ep_fk FOREIGN KEY (pedido) REFERENCES farmacia.pedido(id_pedido),
	CONSTRAINT estatus_fk FOREIGN KEY (estatus) REFERENCES farmacia.estatus(id_estatus),
   CONSTRAINT id_estatus_pedido PRIMARY KEY(pedido, estatus)
);

CREATE TABLE id_gen (gen_name VARCHAR(80), gen_val INTEGER, PRIMARY KEY
(gen_name));

INSERT INTO id_gen(gen_name, gen_val) VALUES("dir_gen",10);
INSERT INTO id_gen(gen_name, gen_val) VALUES("prod_gen",10);
