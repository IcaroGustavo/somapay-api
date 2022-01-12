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
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;

    public static EmpresaRetornoDto valueOf(Empresa empresa) {
        return new EmpresaRetornoDto(
                empresa.getId(), empresa.getCnpj(), empresa.getNomeFantasia(), empresa.getEmail(),
                empresa.getTelefone(), empresa.getEndereco().getCep(), empresa.getEndereco().getLogradouro(),
                empresa.getEndereco().getComplemento(), empresa.getEndereco().getBairro(), empresa.getEndereco().getLocalidade(),
                empresa.getEndereco().getUf(), empresa.getEndereco().getNumero());
    }

}
