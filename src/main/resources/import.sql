insert into Usuario (id, nome, login, senha, ativo) values (1, 'Everson', 'everson', '$2a$10$ARppQC0FRWaGP4pnZqYbpuVyYOWIp4q1r2ViT3PGYK6BafD5PXFiS', true);

insert into Grupo (id, nome, descricao) values (1, 'ANALISTA', 'Grupo de analistas');

insert into Permissao (id, nome) values (1, 'USUARIO');

insert into Usuario_Grupo (usuarios_id, grupos_id) values (1, 1);

insert into Grupo_Permissao (grupos_id, permissoes_id) values (1, 1);
insert into Grupo_Permissao (grupos_id, permissoes_id) values (1, 2);
insert into Grupo_Permissao (grupos_id, permissoes_id) values (1, 3);