package com.api.somapay.teste.dto;

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

    private String telefone;

    @NotNull(message = "O CEP NÃO PODE SER NULO!")
    @NotBlank(message = "O CEP NÃO PODE SER VAZIO!")
    @Size(max = 8, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String cep;

    @NotNull(message = "O LOGRADOURO NÃO PODE SER NULO!")
    @NotBlank(message = "O LOGRADOURO NÃO PODE SER VAZIO!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String logradouro;

    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String complemento;

    @NotNull(message = "O BAIRRO NÃO PODE SER NULO!")
    @NotBlank(message = "O BAIRRO NÃO PODE SER VAZIO!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String bairro;

    @NotNull(message = "A LOCALIDADE NÃO PODE SER NULA!")
    @NotBlank(message = "A LOCALIDADE NÃO PODE SER VAZIA!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String localidade;

    @NotNull(message = "O UF NÃO PODE SER NULO!")
    @NotBlank(message = "O UF NÃO PODE SER VAZIO!")
    @Size(max = 2, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String uf;

    @Size(max = 10, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String numero;
}
