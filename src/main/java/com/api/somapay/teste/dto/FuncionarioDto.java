package com.api.somapay.teste.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {


    @NotNull(message = "A DESCRIÇÃO NÃO PODE SER NULO!")
    @NotBlank(message = "A DESCRIÇÃO NÃO PODE SER VAZIA!")
    @Size(max = 100, message = "LIMITE DE CARACTERES EXCEDIDO!")
    private String funcionario;

    @NotNull(message = "A DATA DE ADMISSÃO NÃO PODE SER NULO!")
    @NotBlank(message = "A DATA DE ADMISSÃO NÃO PODE SER VAZIA!")
    private Date dataAdmissao;

    @Min(value = 1, message = "Ocupação inválida!")
    private long ocupacaoDto;
    
    @Min(value = 1, message = "Empresa inválida!")
    private long empresaDto;

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