package br.com.somapay.desafio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.somapay.desafio.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class UsuarioDto {

    @NotEmpty(message = "O LOGIN NÃO PODE SER VAZIO!")
    @NotNull(message = "O LOGIN NÃO PODE SER NULO!")
    private String login;

    @NotEmpty(message = "A SENHA NÃO PODE SER VAZIA!")
    @NotNull(message = "A SENHA NÃO PODE SER NULA!")
    private String senha;

    public static UsuarioDto valueOf(Usuario usuario) {
        return new UsuarioDto(usuario.getLogin(), usuario.getSenha());
    }
}
