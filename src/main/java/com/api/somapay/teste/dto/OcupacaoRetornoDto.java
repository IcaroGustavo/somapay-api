package com.api.somapay.teste.dto;

import com.api.somapay.teste.model.Ocupacao;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OcupacaoRetornoDto {

    private Long id;
    private String ocupacao;
    private Double salario;

    public static OcupacaoRetornoDto valueOf(Ocupacao ocupacao) {
        return new OcupacaoRetornoDto(ocupacao.getId(), ocupacao.getOcupacao(), ocupacao.getSalario());
    }
}
