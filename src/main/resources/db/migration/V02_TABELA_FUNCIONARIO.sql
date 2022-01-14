CREATE TABLE IF NOT EXISTS FUNCIONARIO (
    CODIGO BIGINT(10) PRIMARY KEY IDENTITY,
    DESCRICAO VARCHAR(100) NOT NULL,
    SITUACAO_FUNCIONARIO INT,
    DATA_ADMISSAO TIMESTAMP NOT NULL
    OCUPACAO_FK INT NOT NULL,
    EMPRESA_FK INT NOT NULL,
    FOREIGN KEY (OCUPACAO_FK) REFERENCES OCUPACAO(CODIGO),    
    FOREIGN KEY (EMPRESA_FK) REFERENCES EMPRESA(CODIGO)    
);