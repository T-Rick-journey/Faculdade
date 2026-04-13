INSERT INTO tb_aluno (id, nome, matricula) VALUES (1, 'João Silva', '2021001');
INSERT INTO tb_aluno (id, nome, matricula) VALUES (2, 'Maria Oliveira', '2021002');
INSERT INTO tb_aluno (id, nome, matricula) VALUES (3, 'Carlos Santos', '2021003');

INSERT INTO tb_publicacoes (id, titulo, codigoPublicacao, autor, ano, tipo) VALUES (1, 'Introdução à Programação', 'IP2021', 'Ana Costa', 2021, 'Livro');
INSERT INTO tb_publicacoes (id, titulo, codigoPublicacao, autor, ano, tipo) VALUES (2, 'Aplicação de Banco de Dados', 'BDA2020', 'Pedro Almeida', 2020, 'Livro');
INSERT INTO tb_publicacoes (id, titulo, codigoPublicacao, autor, ano, tipo) VALUES (3, 'Redes de Computadores', 'RC2019', 'Luisa Fernandes', 2019, 'Livro');

insert into tb_emprestimo (id, id_aluno, id_publicacao, dataEmprestimo, dataDevolucao) values (1, 1, 1, '2024-01-15', '2024-02-15');
insert into tb_emprestimo (id, id_aluno, id_publicacao, dataEmprestimo, dataDevolucao) values (2, 1, 2, '2024-01-15', '2024-02-15');
insert into tb_emprestimo (id, id_aluno, id_publicacao, dataEmprestimo, dataDevolucao) values (3, 1, 3, '2024-01-15', '2024-02-15');
insert into tb_emprestimo (id, id_aluno, id_publicacao, dataEmprestimo, dataDevolucao) values (4, 3, 2, '2024-01-15', '2024-02-15');
insert into tb_emprestimo (id, id_aluno, id_publicacao, dataEmprestimo, dataDevolucao) values (5, 3, 3, '2024-01-15', '2024-02-15');