package br.com.somapay.desafio.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDto {

    @NotNull(message = "Agência não pode ser nula")
    @NotBlank(message = "Agência não pode ser vazia")
    private String agencia;
    @NotNull(message = "Número não pode ser nulo")
    @NotBlank(message = "Número não pode ser vazio")
    private String numero;
    @NotNull(message = "Digito não pode ser nulo")
    @NotBlank(message = "Digito não pode ser vazio")
    private String digito;
    @DecimalMin(value = "0.01", message = "Saldo inválido! Mínimo é R$0,01")
    private Double saldo;

}
