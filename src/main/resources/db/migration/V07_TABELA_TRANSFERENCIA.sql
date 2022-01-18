CREATE TABLE PUBLIC.TRANSFERENCIA (
    ID BIGINT(10) PRIMARY KEY IDENTITY,
    DATA_TRANSFERENCIA TIMESTAMP NOT NULL,
    DATA_CRIACAO TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    VALOR DECIMAL(19, 5) NOT NULL,
    CONTA_ORIGEM_FK INT NOT NULL,
    CONTA_DESTINO_FK INT NOT NULL,
    FOREIGN KEY (CONTA_ORIGEM_FK) REFERENCES PUBLIC.CONTA(ID),
    FOREIGN KEY (CONTA_DESTINO_FK) REFERENCES PUBLIC.CONTA(ID)
);