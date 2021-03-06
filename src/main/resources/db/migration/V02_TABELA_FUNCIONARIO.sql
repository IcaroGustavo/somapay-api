CREATE TABLE PUBLIC.FUNCIONARIO (
    CODIGO BIGINT(10) PRIMARY KEY IDENTITY,
    DESCRICAO VARCHAR(100) NOT NULL,
    SITUACAO_FUNCIONARIO INT,
    DATA_ADMISSAO TIMESTAMP NOT NULL
    OCUPACAO_FK BIGINT(10) NOT NULL,
    EMPRESA_FK BIGINT(10) NOT NULL,
    CONTA_FK BIGINT(10) NOT NULL,
    FOREIGN KEY (OCUPACAO_FK) REFERENCES PUBLIC.OCUPACAO(CODIGO),    
    FOREIGN KEY (EMPRESA_FK) REFERENCES PUBLIC.EMPRESA(CODIGO)    
    FOREIGN KEY (CONTA_FK) REFERENCES PUBLIC.CONTA(CODIGO)    
);