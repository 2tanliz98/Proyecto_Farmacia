-- Datos para la tabla usuario
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(1,"Juan", "Pérez", "Gómez", "juanito", "juan@email.com", 1234567890, "contraseña1", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(2,"María", "Rodríguez","López", "maria123", "maria@email.com", 9876543210,  "password123",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(3,"Carlos", "Sánchez", "Jiménez", "carlitos", "carlos@email.com", 6543219870,  "clave123", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(4,"Laura", "González", "Martínez", "lauraG", "laura@email.com", 7890123456, "pass456",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(5,"David", "López" ,"Pérez", "davido", "david@email.com", 3456789012, "secreto123", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(6,"Ana", "Martínez", "García", "anita", "ana@email.com", 5678901234, "p@ssw0rd",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(7,"Pedro", "Gómez", "Rodríguez", "pedrito", "pedro@email.com", 2345678901, "contrasena1", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(8,"Isabel", "Sánchez", "Pérez", "isabelita", "isabel@email.com", 8901234567, "mypass123",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(9,"Miguel", "Rodríguez", "Sánchez", "migue", "miguel@email.com", 4321098765, "12345678", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(10,"Carmen", "López ","Gómez", "carmenG", "carmen@email.com", 6789012345,  "pass789",1);

-- Datos para la tabla direccion
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(1, "Calle A", "123", "12345", "Colonia 1", "Municipio 1", "Entidad 1",1 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(2, "Calle B", "456", "23456", "Colonia 2", "Municipio 2", "Entidad 2",2 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(3, "Calle C", "789", "34567", "Colonia 3", "Municipio 3", "Entidad 3",3 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(4, "Calle D", "101", "45678", "Colonia 4", "Municipio 4", "Entidad 4",4 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(5, "Calle E", "112", "56789", "Colonia 5", "Municipio 5", "Entidad 5",5 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(6, "Calle F", "213", "67890", "Colonia 6", "Municipio 6", "Entidad 6",6 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(7, "Calle G", "314", "78901", "Colonia 7", "Municipio 7", "Entidad 7",7 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(8, "Calle H", "415", "89012", "Colonia 8", "Municipio 8", "Entidad 8",8 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(9, "Calle I", "516", "90123", "Colonia 9", "Municipio 9", "Entidad 9",9 );
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(10, "Calle J", "617", "01234", "Colonia 10", "Municipio 10", "Entidad , 10",10);

-- Datos para la tabla tarjeta
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(1, 1, "1234567890", "2024-05-01", "VISA");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(2, 2, "9876543210", "2023-12-01", "MASTERCARD");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(3, 3, "5678901234", "2025-09-01", "AMERICAN EXPRESS");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(4, 4, "4567890123", "2024-06-01", "VISA");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(5, 5, "3456789012", "2023-11-01", "MASTERCARD");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(6, 6, "6789012345", "2025-03-01", "AMERICAN EXPRESS");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(7, 7, "2345678901", "2024-08-01", "VISA");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(8, 8, "7890123456", "2023-10-01", "MASTERCARD");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(9, 9, "9012345678", "2025-01-01", "AMERICAN EXPRESS");
INSERT INTO tarjeta(id_tarjeta, usuario, numero_tarjeta, fecha_expiracion, tipo_tarjeta) VALUES(10,10, "3456789010", "2024-07-01", "VISA");

-- Datos para la tabla empresa
INSERT INTO empresa (id_empresa, nombre, direccion) VALUES
(1, 'Empresa1', 'Dirección1'),
(2, 'Empresa2', 'Dirección2'),
(3, 'Empresa3', 'Dirección3'),
(4, 'Empresa4', 'Dirección4'),
(5, 'Empresa5', 'Dirección5'),
(6, 'Empresa6', 'Dirección6'),
(7, 'Empresa7', 'Dirección7'),
(8, 'Empresa8', 'Dirección8'),
(9, 'Empresa9', 'Dirección9'),
(10, 'Empresa10', 'Dirección10');

-- Datos para la tabla articulo
INSERT INTO articulo (id_articulo, marca, nombre, articulo_tipo, empresa, precio, unidades, imagen) VALUES
(1,'Marca1', 'Producto1', 2, 1, 50.00, 100, 'p1.jpg'),
(2,'Marca2', 'Producto2', 2, 2, 75.50, 150, 'p2.jpg'),
(3,'Marca3', 'Producto3', 2, 3, 30.25, 80, 'p3.jpg'),
(4,'Marca4', 'Producto4', 2, 4, 120.00, 200,'p4.jpg'),
(5,'Marca5', 'Producto5', 2, 5, 45.75, 120, 'p5.jpg'),
(6,'Marca6', 'Producto6', 1, 6, 100.00, 180,'p6.jpg'),
(7,'Marca7', 'Producto7', 1, 7, 50.00, 100, 'p7.jpg'),
(8,'Marca8', 'Producto8', 1, 1, 75.50, 150, 'p8.jpg'),
(9,'Marca9', 'Producto9', 1, 2, 30.25, 80, 'p9.jpg'),
(10,'Marca10', 'Producto10', 1,9,120.00, 200,'p10.jpg');

-- Datos para la tabla cat_cosmeticos
INSERT INTO cat_cosmeticos (id_articulo,tono_color) VALUES
(1, 'Rojo'),
(2, 'Azul'),
(3, 'Verde'),
(4, 'Negro'),
(5, 'Blanco');

-- Datos para la tabla cat_farmacos
INSERT INTO cat_farmacos (id_articulo,  ingrediente_activo) VALUES
(6,'Ingrediente6'),
(7,'Ingrediente7'),
(8, 'Ingrediente8'),
(9, 'Ingrediente9'),
(10, 'Ingrediente10');

-- Datos métodos de pago
INSERT INTO metodo_pago(id_metodo_pago,nombre,descripcion) VALUES
(1, 'Tarjeta de Crédito', 'Pago con tarjeta de crédito'),
(2, 'Transferencia Bancaria', 'Pago mediante transferencia bancaria'),
(3, 'Efectivo', 'Pago en efectivo en la entrega');

-- Datos para la tabla pedido
INSERT INTO pedido (id_pedido, metodo_pago, fecha, usuario, total) VALUES
(1, 1, '2023-01-15', 1, 500),
(2, 2, '2023-02-20', 2, 750),
(3, 3, '2023-03-25', 3, 1200),
(4, 4, '2023-04-10', 4, 300),
(5, 4, '2023-05-05', 5, 900),
(6, 1, '2023-06-15', 6, 600),
(7, 2, '2023-04-10', 7, 450),
(8, 3, '2023-08-25', 8, 800),
(9, 4, '2023-09-10', 9, 200),
(10, 1, '2023-10-05', 10, 1000);

-- Datos para la tabla detalle_compra
INSERT INTO detalle_compra (pedido, articulo, cantidad) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 3),
(2, 4, 2),
(3, 5, 1),
(4, 6, 4),
(5, 7, 2),
(6, 8, 3),
(7, 9, 1),
(8, 10, 2);

-- Datos para la tabla estatus (de pedido)
-- DELETE FROM estatus;
-- DROP  TABLE historico_estatus_pedido;
-- DROP  TABLE estatus;
INSERT INTO estatus(nombre, descripcion) VALUES
('EN PROCESO','El pedido se está verificando'),
('ENVIADO','El pedido ha sido enviado'),
('RECIBIDO','El pedido ha sido recibido por el usuario cliente');


INSERT INTO historico_estatus_pedido(pedido,estatus,fecha) VALUES
(13,1,'2024-01-09'),
(12,2,'2024-01-09'),
(11,1,'2024-01-09'),
(11,2,'2024-01-09'),
(11,3,'2024-01-09');
