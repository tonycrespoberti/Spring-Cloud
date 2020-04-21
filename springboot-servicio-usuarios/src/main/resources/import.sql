INSERT INTO usuarios (username, password, enabled, apellido, email) VALUES ('tony', '1234', 1,'Crespo', 'tonycrespo@hotmail.com');
INSERT INTO usuarios (username, password, enabled, apellido, email) VALUES ('carlos', '1234', 1, 'Castro', 'carloscastro@hotmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);