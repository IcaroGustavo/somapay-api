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
    private Long idOcupacao;
    
    @Min(value = 1, message = "Empresa inválida!")
    private Long idEmpresa;
}