package com.api.somapay.teste.dto;

import java.util.Date;

import com.api.somapay.teste.model.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FuncionarioRetornoDto {

    private Long id;
    private String funcionario;
    private Date dataAdmissao;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;
    private OcupacaoRetornoDto ocupacao;
    private EmpresaRetornoDto empresa;

    public static FuncionarioRetornoDto valueOf(Funcionario funcionario) {
        return new FuncionarioRetornoDto(funcionario.getId(), funcionario.getFuncionario(),
                funcionario.getDataAdmissao(), funcionario.getEndereco().getCep(),
                funcionario.getEndereco().getLogradouro(), funcionario.getEndereco().getComplemento(),
                funcionario.getEndereco().getBairro(), funcionario.getEndereco().getLocalidade(),
                funcionario.getEndereco().getUf(), funcionario.getEndereco().getNumero(),
                OcupacaoRetornoDto.valueOf(funcionario.getOcupacao()),
                EmpresaRetornoDto.valueOf(funcionario.getEmpresa()));
    }
}
