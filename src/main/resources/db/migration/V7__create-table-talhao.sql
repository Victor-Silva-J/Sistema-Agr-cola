CREATE TABLE talhao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_talhao VARCHAR(255),
    codigo VARCHAR(255),
    area DECIMAL(19,2),
    cultura VARCHAR(255),
    tipo_de_solo VARCHAR(255),
    codigo_fazenda BIGINT NOT NULL,
    CONSTRAINT fk_talhao_fazenda FOREIGN KEY (codigo_fazenda) REFERENCES fazenda(id)
);
