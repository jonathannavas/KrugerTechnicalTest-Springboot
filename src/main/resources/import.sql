INSERT INTO vacunas(nombre) VALUES ('Ninguna');
INSERT INTO vacunas(nombre) VALUES ('Sputnik');
INSERT INTO vacunas(nombre) VALUES ('AstraZeneca');
INSERT INTO vacunas(nombre) VALUES ('Pfizer');
INSERT INTO vacunas(nombre) VALUES ('Jhonson&Jhonson');

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id, role_id) VALUES ('Administrador', 'Administrador', 'admin@admin', 1725635310, '1725635310', '12345', false, 1, 2);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id, role_id) VALUES ('Gabriel', 'Navas', 'gabriel@jonathan-navas.com', 1725635427, 'janavas', '12345', false, 1, 1);
