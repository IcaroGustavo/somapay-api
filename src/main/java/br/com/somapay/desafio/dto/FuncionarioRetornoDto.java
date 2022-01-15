package br.com.somapay.desafio.dto;

import java.util.Date;

import br.com.somapay.desafio.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FuncionarioRetornoDto {

    private Long id;
    private String funcionario;
    private Date dataAdmissao;
    private OcupacaoRetornoDto ocupacao;
    private EmpresaRetornoDto empresa;

    public static FuncionarioRetornoDto valueOf(Funcionario funcionario) {
        return new FuncionarioRetornoDto(funcionario.getId(), funcionario.getFuncionario(),
                funcionario.getDataAdmissao(), OcupacaoRetornoDto.valueOf(funcionario.getOcupacao()),
                EmpresaRetornoDto.valueOf(funcionario.getEmpresa()));
    }
}
