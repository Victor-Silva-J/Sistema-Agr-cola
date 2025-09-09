CREATE TABLE talhao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_talhao VARCHAR(3) NOT NULL,
    codigo VARCHAR(255) NOT NULL,
    area DECIMAL(19,2),
    cultura VARCHAR(255),
    tipo_de_solo VARCHAR(255),
    codigo_fazenda VARCHAR(2) NOT NULL,
    CONSTRAINT fk_talhao_fazenda FOREIGN KEY (codigo_fazenda) REFERENCES fazenda(codigoFazenda)
);
