package com.api.somapay.teste.exception;

public class FuncionarioNaoEncontradoException extends BusinessException {
    
    private static String mensagemPadrao = "Funcionário não encontrado.";

    public FuncionarioNaoEncontradoException() {
        super(mensagemPadrao);
    }

    public FuncionarioNaoEncontradoException(String message) {
        super(message);
    }

    public FuncionarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioNaoEncontradoException(Throwable cause) {
        super(mensagemPadrao, cause);
    }

    public FuncionarioNaoEncontradoException(long id) {
        super("Funcionário ID: " + id + " não encontrada.");
    }
}
