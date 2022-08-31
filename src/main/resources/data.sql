insert into TB_TIPOPESSOA (codigo, descricao) values (1, 'Fisica');

insert into TB_TIPOPESSOA (codigo, descricao) values (2, 'Juridica');

insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (1, 'Maria', 1, '457.468.540-93', '(99)99999-9999', 'maria@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (2, 'San Marino Design Grafico', 2, '21.843.963/0001-27', '(99)99999-9999', 'sanmarino@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (3, 'Lucas Esmeraldino', 1, '002.062.810-21', '(99)99999-9999', 'lucas@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (4, 'Ricardo Alves', 1, '633.107.330-25', '(99)99999-9999', 'ricardo@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (5, 'Marilene Mendes', 1, '213.637.120-71', '(99)99999-9999', 'marilene@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (6, 'Carlos Almeida', 1, '392.542.780-50', '(99)99999-9999', 'carlos@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (7, 'Mendes & Rocha Decoracoes', 2, '27.050.665/0001-66', '(99)99999-9999', 'mendeserocha@email.com');
insert into TB_CLIENTE (codigo, nome, codigoTipoPessoa, cpfCnpj, telefone, email) values (8, 'Favarin Moveis', 2, '30.864.991/0001-11', '(99)99999-9999', 'favarin@email.com');


insert into TB_PRODUTO (codigo, nome, preco) values (1, 'Suporte para celular Samsung', 19.99);
insert into TB_PRODUTO (codigo, nome, preco) values (2, 'Capinha para celular Samsung S10 Plus', 59.89);
insert into TB_PRODUTO (codigo, nome, preco) values (3, 'Oleo Extraordinario Elseve Tratamento', 40.49);
insert into TB_PRODUTO (codigo, nome, preco) values (4, 'Revlon Professional Uniq', 79.90);
insert into TB_PRODUTO (codigo, nome, preco) values (5, 'Samsung Galaxy A03 Dual SIM', 949);
insert into TB_PRODUTO (codigo, nome, preco) values (6, 'Notebook Asus X515JA slate gray', 2499);
insert into TB_PRODUTO (codigo, nome, preco) values (7, 'Camiseta Paris Reserva', 105.90);
insert into TB_PRODUTO (codigo, nome, preco) values (8, 'Calca Jeans Masculina Slim Tijuca Reserva', 125.90);
insert into TB_PRODUTO (codigo, nome, preco) values (9, 'Tenis New Balance 393 | Casual Feminino', 279.99);
insert into TB_PRODUTO (codigo, nome, preco) values (10, 'Bolsa Feminina Estilo Bucket/bau 2 Alcas Fashion', 200);


insert into TB_STATUSPEDIDO (codigo, descricao) values (1, 'Fechado');