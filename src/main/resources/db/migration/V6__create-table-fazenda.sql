create table fazenda(
	ID bigint not null auto_increment,
	CODIGOFAZENDA varchar(2) not null,
	FAZENDA varchar(100) not null,
	MUNICIPIO varchar(100) not null,
	CEP int not null,
	
	primary key(id),
	unique(CODIGOFAZENDA));