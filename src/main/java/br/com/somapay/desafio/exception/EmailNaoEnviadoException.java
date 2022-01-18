package br.com.somapay.desafio.exception;

public class EmailNaoEnviadoException extends BusinessException {
    private static String mensagemPadrao = "E-MAIL NÃO ENVIADO!!.";

    public EmailNaoEnviadoException() {
        super(mensagemPadrao);
    }

    public EmailNaoEnviadoException(String message) {
        super(message);
    }

    public EmailNaoEnviadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNaoEnviadoException(Throwable cause) {
        super(mensagemPadrao, cause);
    }
}
