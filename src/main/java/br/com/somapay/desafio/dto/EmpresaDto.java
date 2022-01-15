package br.com.somapay.desafio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto {

    @NotNull(message = "O CNPJ NÃO PODE SER NULO!")
    @NotBlank(message = "O CNPJ NÃO PODE SER VAZIO!")
    @CNPJ(message = "CNPJ INVÁLIDO!")
    private String cnpj;

    @NotNull(message = "O NOME FANTASIA NÃO PODE SER NULO!")
    @NotBlank(message = "O NOME FANTASIA NÃO PODE SER VAZIO!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String nomeFantasia;

    @NotNull(message = "O E-MAIL NÃO PODE SER NULO!")
    @NotBlank(message = "O E-MAIL NÃO PODE SER VAZIO!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String email;

    @NotNull(message = "O TELEFONE NÃO PODE SER NULO!")
    @NotBlank(message = "O TELEFONE NÃO PODE SER VAZIO!")
    private String telefone;
}
