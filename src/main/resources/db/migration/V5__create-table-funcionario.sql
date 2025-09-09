create table funcionarios(
	ID bigint not null auto_increment,
	NOME varchar(50) not null,
	TURMA int not null,
	SECAO int not null,
	DESCRICAO_DA_SECAO varchar(20) not null,
	FUNCAO varchar(50) not null,
	TIPO varchar(20) not null,
	ATIVO boolean not null,
	DATA_DE_NASCIMENTO DATE not null,
	CPF char(11) not null,
	CTPS char(8) not null,
	ADMISSAO DATE not null,
	DEMISSAO DATE ,
	PIS char(11) not null,
	
	primary key (ID),
	CONSTRAINT chk_cpf CHECK (CPF REGEXP '^[0-9]{11}$')	
);