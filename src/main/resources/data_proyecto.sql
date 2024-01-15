-- Datos para la tabla usuario
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(1,"Juan", "Pérez", "Gómez", "juanito", "juan@email.com", 5534567890, "$2a$10$rKgfPGjv7LqrvIa2I4IllesL0XrwRP8JFuPbHnmk1yAxQfOtawlEO", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(2,"María", "Rodríguez","López", "maria123", "maria@email.com", 5576543210, "$2a$10$bP4u8SpDhcgYjIRCueyysO6WQYKVQj4mTI2L607jbbWA5jWc8QCgq",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(3,"Carlos", "Sánchez", "Jiménez", "carlitos", "carlos@email.com", 5543219870, "$2a$10$ea0oS9.mjRAgVreoDv5TXevFzJjHsgi7ZuZvWW4WQ3DKtdk0uM6N.", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(4,"Laura", "González", "Martínez", "lauraG", "laura@email.com", 5590123456, "$2a$10$7QF90Kt9gKu3rcTzF10fLuPwgXexV7DJHEnrQvye/aixqTOv6QCGy",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(5,"David", "López" ,"Pérez", "davido", "david@email.com", 5556789012, "$2a$10$oGWpnU37GAvPyc6D.ydPcuz4kLwVOryMtBAsMaly4zb3kQR21cu8i", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(6,"Ana", "Martínez", "García", "anita", "ana@email.com", 5578901234, "$2a$10$lCsLRhgnpMnNY9rbSBEQEOdXmsHR33BiCpeeE/WNiTmWpw3izPQO.",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(7,"Pedro", "Gómez", "Rodríguez", "pedrito", "pedro@email.com", 5545678901, "$2a$10$aIhNUR3/W/6.iGEjdRVeqO7srnvD6tKvYOVNTLwdkBAZ.DsGMj3kO", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(8,"Isabel", "Sánchez", "Pérez", "isabelita", "isabel@email.com", 5501234567, "$2a$10$TzDcQMkMKOCAx2kpTT3QW.xD.qvWx/yBGKJnmYDAnfl5MkAmHXa0m",1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(9,"Miguel", "Rodríguez", "Sánchez", "migue", "miguel@email.com", 5521098765, "$2a$10$ylT9HTpFtmmqAtfJ.dHRYuMzmT9RceXyrgRUsC2a2pwNGUH7ryIZ2", 1);
INSERT INTO usuario(id_usuario, nombre, ap_pat, ap_mat, alias, email, telefono,  contrasenia, rol) VALUES(10,"Santiago","Peñaloza", "Lugo", "Santi","santi@gmail.com", 5589012345,  "$2a$10$7apqqHoRj5vMkDNIB04sdut39Gaw7lf2l.z1usx9ySlH3lYr9HQ16",1);

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
INSERT INTO direccion (gen_val, calle, numero, codigo_postal, colonia, municipio, entidad_federativa, usuario) VALUES(10, "Alhelí", "12", "01234", "Palmas", "Magdalena Contreras", "CDMX",10);

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
(1,'Marca1', 'Radian Violet Shampoo', 2, 1, 50.00, 100, 'p1.jpg'),
(2,'Marca2', 'Cantu shampoo', 2, 2, 75.50, 150, 'p2.jpg'),
(3,'Marca3', 'Purple water creme', 2, 3, 30.25, 80, 'p3.jpg'),
(4,'Marca4', 'Tinta de labios', 2, 4, 120.00, 200,'p4.jpg'),
(5,'Marca5', 'Labial Mate', 2, 5, 45.75, 120, 'p5.jpg'),
(6,'Marca6', 'Jarabe Duphalac', 1, 6, 100.00, 180,'p6.jpg'),
(7,'Marca7', 'Cardispan', 1, 7, 50.00, 100, 'p7.jpg'),
(8,'Marca8', 'Amoebriz', 1, 1, 75.50, 150, 'p8.jpg'),
(9,'Marca9', 'Alevian Duo', 1, 2, 30.25, 80, 'p9.jpg'),
(10,'Marca10', 'Alin - Dexametasona', 1,9,120.00, 200,'p10.jpg');

INSERT INTO articulo(id_articulo, marca, nombre, descripcion, articulo_tipo, empresa, precio, unidades, imagen)VALUES 
(11,'Marca10', 'Suerox Manzana Electrólitos Orales 0 Azúcar', 'Suerox Adulto Manzana C/630Ml', 1, 6, 22.00, 100, 'p11.jpg'),
(12,'Marca10', 'Enterogermina', 'Los probióticos de Enterogermina 4 billones estimulan las defensas de toda la familia', 1, 6, 345.00, 80, 'p12.jpg'),
(13,'Marca10', 'ADVIL analgésico', 'ADVIL ANALGÉSICO 400 MG 20 CÁPSULAS', 1, 6, 149.00, 100, 'p13.jpg'),
(14,'Marca10', 'VICK PYRENA antigripal sabor manzanilla 5 sobres.',  'Vick Pyrena® es un té antigripal que contiene paracetamol 500 mg y fenilefrina 10 mg que alivia los síntomas asociados al resfriado', 1, 6, 22.00, 100, 'p14.jpg'),
(15,'Marca10', 'GESTOMEG OMEGA 3 vitaminas', 'Caja con 30 capsulas. Gestomeg Omega 3, ácido fólico, hierro, vitamina C, yodo, otras vitaminas y minerales.', 1, 6, 365.00, 100, 'p15.jpg'),
(21,'Marca2', 'TINTA LABIOS Y MEJILLAS', 'Tintas de fórmula acuosa y ligera con la que se pueden crear diferentes looks: desde ligeros y transparentes hasta de cobertura media a intensa, logrando un efecto mate de gran duración en tus labios y mejillas', 2, 1, 50.00, 100, 'p21.jpg'),
(22, 'Marca2', 'Gliter', 'Añade un toque de fantasía y glamour colocando un poco de glitter sobre tu maquillaje o uñas, el límite es tu imaginación.', 2, 2, 15.50, 200, 'p22.jpg'),
(23, 'Marca2','Maquillaje compacto', 'Acabado mate. No contiene aceites. Disimula el brillo en el rostro. Disimula ligeras líneas de expresión. Recomendado por maquillistas profesionales.', 2, 2, 55.00, 100, 'p23.jpg'),
(24, 'Marca2','Primer para rostro', 'Primer de textura suave que te ayudará a disimular las ligeras líneas de expresión y poros de la piel.', 2, 2, 110.63, 100, 'p24.jpg'),
(25, 'Marca2', 'Labial mate', 'Fórmula de textura cremosa y efecto mate que no reseca tus labios. Se desliza fácilmente, lo que te permitirá una aplicación más uniforme y te hará lucir unos labios fantásticos.', 2, 2, 30.60, 100, 'p25.jpg');

-- Datos para la tabla cat_cosmeticos
-- DROP TABLE cat_cosmeticos;
INSERT INTO cat_cosmeticos (id_articulo,tono_color) VALUES
(1, 'no aplica'),
(2, 'no aplica'),
(3, 'no aplica'),
(4, 'no aplica'),
(5, 'rojo'),
(24, 'no aplica'),
(21, 'Rosa'),
(22, 'Plata'),
(25, 'Morado'),
(23, 'Canela');

-- Datos para la tabla cat_farmacos
INSERT INTO cat_farmacos (id_articulo,  ingrediente_activo) VALUES
(6,'Ingrediente6'),
(7,'Ingrediente7'),
(8, 'Ingrediente8'),
(9, 'Ingrediente9'),
(10, 'Ingrediente10'),
(11,'Ingrediente6'),
(12,'Ingrediente7'),
(13, 'Ingrediente8'),
(14, 'Ingrediente9'),
(15, 'Ingrediente10');

-- Datos métodos de pago
INSERT INTO metodo_pago(id_metodo_pago,nombre,descripcion) VALUES
(1, 'Tarjeta de Crédito', 'Pago con tarjeta de crédito'),
(2, 'Transferencia Bancaria', 'Pago mediante transferencia bancaria'),
(3, 'PayPal', 'Pago mediante PayPal'),
(4, 'Efectivo', 'Pago en efectivo en la entrega');

-- Datos para la tabla pedido
INSERT INTO pedido (id_pedido, metodo_pago, fecha, usuario, total) VALUES
(1, 1, '2023-01-15', 1, 100),
(2, 2, '2023-02-20', 2, 75.50),
(3, 3, '2023-03-25', 3, 35.25),
(4, 4, '2023-04-10', 4, 120),
(5, 4, '2023-05-05', 5, 120),
(6, 1, '2023-06-15', 6, 100),
(7, 2, '2023-04-10', 7, 50),
(8, 3, '2023-08-25', 8, 75),
(9, 4, '2023-09-10', 9, 30.25),
(10, 1, '2023-10-05', 10, 120);

-- Datos para la tabla detalle_compra
INSERT INTO detalle_compra (pedido, articulo, cantidad) VALUES
(1, 1, 2),
(2, 2, 1),
(3, 3, 1),
(4, 4, 1),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 1),
(9, 9, 1),
(10, 10, 1);

-- Datos para la tabla estatus (de pedido)
-- DELETE FROM estatus;
-- DROP  TABLE historico_estatus_pedido;
-- DROP  TABLE estatus;
INSERT INTO estatus(nombre, descripcion) VALUES
('EN PROCESO','El pedido se está verificando'),
('ENVIADO','El pedido ha sido enviado'),
('RECIBIDO','El pedido ha sido recibido por el usuario cliente');


INSERT INTO historico_estatus_pedido(pedido,estatus,fecha) VALUES
(1,3,'2024-01-09'),
(2,2,'2024-01-09'),
(3,1,'2024-01-09'),
(4,2,'2024-01-09'),
(5,3,'2024-01-09'),
(6,2,'2024-01-09'),
(7,1,'2024-01-09'),
(8,2,'2024-01-09'),
(9,3,'2024-01-09'),
(10,3,'2024-01-09');
