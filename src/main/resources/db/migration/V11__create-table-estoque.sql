CREATE TABLE estoque(
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	tipo VARCHAR(50) NOT NULL,
	quantidadeAtual DECIMAL (10,2) NOT NULL,
	unidadeMedia ENUM('KG', 'L', 'TON', 'SC') NOT NULL,
	
	primary key(id)
);