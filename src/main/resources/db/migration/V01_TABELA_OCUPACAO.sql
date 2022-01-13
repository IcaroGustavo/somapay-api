CREATE SCHEMA IF NOT EXISTS SIMULADOR;

CREATE TABLE IF NOT EXISTS SIMULADOR.OCUPACAO (
    CODIGO BIGINT(10) PRIMARY KEY IDENTITY ,
    DESCRICAO VARCHAR(100) NOT NULL,
    SALARIO DOUBLE PRECISION NOT NULL,
)ENGINE=InnoDB DEFAULT CHARSET=utf8;