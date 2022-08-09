insert into TB_TIPOPESSOA (codigo, descricao) values (1, 'Fisica');

insert into TB_TIPOPESSOA (codigo, descricao) values (2, 'Juridica');

insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (1, 'Maria', 1, '457.468.540-93', '(99)99999-9999', 'maria@email.com');

insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (2, 'San Marino', 2, '21.843.963/0001-27', '(99)99999-9999', 'sanmarino@email.com');

insert into TB_PRODUTO (codigo, nome, preco) values (1, 'Suporte para celular Samsung', 19.99);

insert into TB_PRODUTO (codigo, nome, preco) values (2, 'Capinha para celular Samsung S10 Plus', 59.89);

insert into TB_STATUSPEDIDO (codigo, descricao) values (1, 'Emitido');

insert into TB_STATUSPEDIDO (codigo, descricao) values (2, 'Aguardando');

insert into TB_STATUSPEDIDO (codigo, descricao) values (3, 'Cancelado');