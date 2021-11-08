INSERT INTO vacunas(nombre) VALUES ('Ninguna');
INSERT INTO vacunas(nombre) VALUES ('Sputnik');
INSERT INTO vacunas(nombre) VALUES ('AstraZeneca');
INSERT INTO vacunas(nombre) VALUES ('Pfizer');
INSERT INTO vacunas(nombre) VALUES ('Jhonson&Jhonson');

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id ) VALUES ('Administrador', 'Administrador', 'admin@admin.com', 1725630000, '1725630000', '$2a$10$Ek1MvuC56CzVNpsYOL935.kOIdFLcleoxcepaL9J79nmWK5Q7GVpK', false, 1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id) VALUES ('Gabriel', 'Navas', 'gabriel@jonathan-navas.com', 1725630001, '1725630001', '$2a$10$Ek1MvuC56CzVNpsYOL935.kOIdFLcleoxcepaL9J79nmWK5Q7GVpK', false, 1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Alex', 'Diaz', 'alexd@gmail.com', 1111111111, '1111111111', '$2a$10$f23NALlaFFVsZRkOS7kPKusOXZRKfRYRIDsPVJ6A5ayXnUnOVVUXC', true, 2,'2021-11-01',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Jhon', 'Doe', 'jdoe@gmail.com', 2222222222, '2222222222', '$$2a$10$ivoAXjEQI.bFZqlIERm.QeBp7PuEoS3Pm1JVu9Wv5HjBcCXU.sjMC', true, 2,'2021-11-02',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Antonio', 'Freire', 'afreire@gmail.com', 3333333333, '3333333333', '$2a$10$ueUOozLCXUH8r5qysRH1QuyANgZnW8srRwWe1.dS8ZBLRUlLmGwjW', true, 3,'2021-11-03',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Lucas', 'Avila', 'lavila@gmail.com', 4444444444, '4444444444', '$2a$10$b7Qg4vpM2N.XErfKl671cuEl/L1r6tfCkhjdAyEic2N71u/Ks9OIa', true, 3,'2021-11-04',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Luis', 'Padilla', 'lpadilla@gmail.com', 5555555555, '5555555555', '$2a$10$Q9BabOZgwOBPIJXJiGLCUeR9cVBaLxH3Hgykz2JfKykXAR8pY9kgS', true, 4,'2021-11-05',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Juan', 'Aparicio', 'japaricio@gmail.com', 6666666666, '6666666666', '$2a$10$rhRvzMzIDVtDnMG5jWkskumxIC9n6fBLnraNaxrmvabH9W0ZPfqhK', true, 4,'2021-11-06',2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Issac', 'Perez', 'iperez@gmail.com', 7777777777, '7777777777', '$2a$10$7Arfb1tZP6veuj80UyYVPuR2/5xJQ2mk5xjAr3N2RDzOzE6irmdIa', true, 5,'2021-11-07',1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id,fecha_vacuna,num_dosis) VALUES ('Juan', 'Codina', 'jcodina@gmail.com', 8888888888, '8888888888', '$2a$10$23dtOz2xZW0/hEu38WzVpOy2lulVqeiM/tSjWj/cahIKagCAq55Ma', true, 5,'2021-11-08',1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id) VALUES ('Pedro', 'Domingo', 'pdomingo@gmail.com', 9999999999, '9999999999', '$2a$10$D6QAcjA2sQVALvFWYbzYTe56JW.WjJ7HLuxi/jot05Ob9R/Qb.xNS', false, 1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id) VALUES ('Gerard', 'Escudero', 'gescudero@gmail.com', 1010101010, '1010101010', '$2a$10$.R4YEt23tDPICrSKThluy.uGPhu9EqeGY6xUAfiSTBRUJ6fYUW/b.', false, 1);


--INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (3, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (4, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (5, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (6, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (7, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (8, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (9, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (10, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (11, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (12, 1);