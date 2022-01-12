package com.api.somapay.teste.enums;

import lombok.Getter;

@Getter
public enum SituacaoFuncionarioEnum {

    ATIVO(1, "ATIVO"),
    FERIAS(2, "FÉRIAS"),
    LICENCA(3, "Licença");

    private Integer codigo;
    private String descricao;

    SituacaoFuncionarioEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}
