package br.com.somapay.desafio.dto;

import br.com.somapay.desafio.model.Ocupacao;
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
