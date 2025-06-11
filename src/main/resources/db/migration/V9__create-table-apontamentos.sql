CREATE TABLE apontamentos(
	id BIGINT NOT NULL AUTO_INCREMENT,
	data_ DATE NOT NULL,
	safra TINYINT(4) NOT NULL,
	funcionario_id BIGINT NOT NULL,
	codigo_servico TINYINT(3) NOT NULL,
	numero_talhao INT CHECK (numero_talhao BETWEEN 0 AND 99999),
	cubagem INT CHECK (cubagem >= 0),
	tarefa DECIMAL(3,2),
	
	PRIMARY KEY(id)

);