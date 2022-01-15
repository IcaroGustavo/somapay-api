package br.com.somapay.desafio.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcupacaoDto {

    @NotNull(message = "A DESCRIÇÃO DA OCUPAÇÃO NÃO PODE SER NULA!")
    @NotBlank(message = "A DESCRIÇÃO DA OCUPAÇÃO NÃO PODE SER VAZIA!")
    private String ocupacao;

    @DecimalMin(value = "0.01", message = "Salário inválido! Mínimo é R$0,01")
    private Double salario;
}
