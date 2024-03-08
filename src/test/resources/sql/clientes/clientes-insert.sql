insert into USUARIOS (id, username, password, role) values (100, 'ana@gmail.com', '$2a$12$prQNl61yWrdh8t6/e5esYuO7CKwCRZ6Yjjp6iow0LgyDk/jgGJgz.', 'ROLE_ADMIN');
insert into USUARIOS (id, username, password, role) values (101, 'bia@gmail.com', '$2a$12$prQNl61yWrdh8t6/e5esYuO7CKwCRZ6Yjjp6iow0LgyDk/jgGJgz.', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (102, 'bob@gmail.com', '$2a$12$prQNl61yWrdh8t6/e5esYuO7CKwCRZ6Yjjp6iow0LgyDk/jgGJgz.', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (103, 'toby@gmail.com', '$2a$12$prQNl61yWrdh8t6/e5esYuO7CKwCRZ6Yjjp6iow0LgyDk/jgGJgz.', 'ROLE_CLIENTE');

insert into CLIENTES(id, nome, cpf, id_usuario) values (10, 'Bianca Silva', '18258332066', 101);
insert into CLIENTES(id, nome, cpf, id_usuario) values (20, 'Roberto Gomes', '39771964054', 102);
