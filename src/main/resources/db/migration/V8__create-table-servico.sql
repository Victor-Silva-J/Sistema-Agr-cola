create table servico(
	id BIGINT NOT NULL AUTO_INCREMENT,
	codigo_servico varchar(265),
	descricao varchar(50),
	centro_custo varchar(50),
	
	primary key (id)
);