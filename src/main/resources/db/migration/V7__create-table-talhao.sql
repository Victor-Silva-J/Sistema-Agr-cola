CREATE TABLE talhao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_fazenda VARCHAR(2) NOT NULL,
    area DECIMAL(19,2),
    cultura VARCHAR(255),
    tipo_de_solo VARCHAR(255),
    numero_talhao VARCHAR(3) NOT NULL,
    codigo VARCHAR(255)  AS (CONCAT(codigo_fazenda, numero_talhao)) STORED,
    CONSTRAINT fk_talhao_fazenda FOREIGN KEY (codigo_fazenda) REFERENCES fazenda(codigoFazenda)
);
