package br.com.somapay.desafio.exception;

public class OcupacaoNaoEncontradaException extends BusinessException {

    private static String mensagemPadrao = "Ocupação não encontrada.";

    public OcupacaoNaoEncontradaException() {
        super(mensagemPadrao);
    }

    public OcupacaoNaoEncontradaException(String message) {
        super(message);
    }

    public OcupacaoNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public OcupacaoNaoEncontradaException(Throwable cause) {
        super(mensagemPadrao, cause);
    }

    public OcupacaoNaoEncontradaException(long id) {
        super("Ocupação ID: " + id + " não encontrada.");
    }

}
