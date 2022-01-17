package br.com.somapay.desafio.exception;

public class UsuarioNaoEncontradoException extends BusinessException {

    private static String mensagemPadrao = "Usuário não encontrado.";

    public UsuarioNaoEncontradoException() {
        super(mensagemPadrao);
    }

    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNaoEncontradoException(Throwable cause) {
        super(mensagemPadrao, cause);
    }

    public UsuarioNaoEncontradoException(long id) {
        super("Usuário ID: " + id + " não encontrado.");
    }

    public UsuarioNaoEncontradoException(String login) {
        super("Usuário: " + login + "não encontrado.");
    }
}
