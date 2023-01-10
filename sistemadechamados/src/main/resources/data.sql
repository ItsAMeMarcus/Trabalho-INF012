INSERT INTO USUARIOS(nome, email, userId) VALUES('Manoel Neto', 'manoel@gmail.com', '123456manoel');
INSERT INTO USUARIOS(nome, email, userId) VALUES('Joao Pedro Barreto', 'jpbarreto@gmail.com', '123456joao');

INSERT INTO CLIENTES(nome, cnpj, endereco) VALUES('Empresa Ficticia 1', '12.341.678/0001-23', 'Av Joao Tavares, 32');
INSERT INTO CLIENTES(nome, cnpj, endereco) VALUES('Empresa Ficticia 2', '34.354.823/0001-21', 'Av Tancredo Neves, 51');

INSERT INTO CHAMADOS(cliente_id, assunto, status, Data_Cadastro) VALUES(1, 'Suporte X', 'EM_ABERTO', '2021-05-05');
INSERT INTO CHAMADOS(cliente_id, assunto, status, Data_Cadastro) VALUES(2, 'Suporte XYZ', 'CONCLUIDO', '2019-09-26');