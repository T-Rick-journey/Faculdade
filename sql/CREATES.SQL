CREATE TABLE IF NOT EXISTS tb_aluno (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255),
	matricula VARCHAR(50)  UNIQUE
);

CREATE TABLE IF NOT EXISTS tb_publicacoes (
	id SERIAL PRIMARY KEY,
	titulo VARCHAR(255),
	codigo_publicacao varchar(255),
	autor VARCHAR(255),
	ano_publicacao INT,
	tipo varchar(255)
);

CREATE TABLE IF NOT EXISTS tb_emprestimo (
	id SERIAL PRIMARY KEY,
	id_aluno INT,
	id_publicacao INT,
	data_emprestimo DATE,
	data_devolucao DATE,
	FOREIGN KEY (id_aluno) REFERENCES tb_aluno(id),
	FOREIGN KEY (id_publicacao) REFERENCES tb_publicacoes(id)
);