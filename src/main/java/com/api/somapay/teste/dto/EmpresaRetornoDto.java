package com.api.somapay.teste.dto;

import com.api.somapay.teste.model.Empresa;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmpresaRetornoDto {

    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private String email;
    private String telefone;

    public static EmpresaRetornoDto valueOf(Empresa empresa) {
        return new EmpresaRetornoDto(
                empresa.getId(), empresa.getCnpj(), empresa.getNomeFantasia(), empresa.getEmail(),
                empresa.getTelefone());
    }

}
