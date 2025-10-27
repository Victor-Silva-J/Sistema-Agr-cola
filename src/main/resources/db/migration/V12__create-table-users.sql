CREATE TABLE users (
	id bigint not null AUTO_INCREMENT,
	_login VARCHAR(20) NOT NULL UNIQUE,
	_password VARCHAR(20) NOT NULL,
	_role VARCHAR(20) NOT NULL,
	
	PRIMARY KEY(id)
	
);