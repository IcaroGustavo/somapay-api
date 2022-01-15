package br.com.somapay.desafio.exception;


public class EmpresaNaoEncontradaException extends BusinessException {
    
    private static String mensagemPadrao = "Empresa não encontrada.";

    public EmpresaNaoEncontradaException() {
        super(mensagemPadrao);
    }

    public EmpresaNaoEncontradaException(String message) {
        super(message);
    }

    public EmpresaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaNaoEncontradaException(Throwable cause) {
        super(mensagemPadrao, cause);
    }

    public EmpresaNaoEncontradaException(long id) {
        super("Empresa ID: " + id + " não encontrada.");
    }
}
