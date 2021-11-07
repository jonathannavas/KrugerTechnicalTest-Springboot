INSERT INTO vacunas(nombre) VALUES ('Ninguna');
INSERT INTO vacunas(nombre) VALUES ('Sputnik');
INSERT INTO vacunas(nombre) VALUES ('AstraZeneca');
INSERT INTO vacunas(nombre) VALUES ('Pfizer');
INSERT INTO vacunas(nombre) VALUES ('Jhonson&Jhonson');

INSERT INTO roles(nombre) VALUES ('ROLE_USER');
INSERT INTO roles(nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id ) VALUES ('Administrador', 'Administrador', 'admin@admin.com', 1725630000, '1725630000', '$2a$10$Ek1MvuC56CzVNpsYOL935.kOIdFLcleoxcepaL9J79nmWK5Q7GVpK', false, 1);
INSERT INTO usuarios (nombre, apellido, email, cedula, username, password, estado, vacuna_id) VALUES ('Gabriel', 'Navas', 'gabriel@jonathan-navas.com', 1725630001, '1725630001', '$2a$10$Ek1MvuC56CzVNpsYOL935.kOIdFLcleoxcepaL9J79nmWK5Q7GVpK', false, 1);

--INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);