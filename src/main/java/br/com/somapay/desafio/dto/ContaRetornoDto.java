package br.com.somapay.desafio.dto;

import br.com.somapay.desafio.model.Conta;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ContaRetornoDto {

    private long id;
    private String banco;
    private String agencia;
    private String numero;
    private String digito;
    private Double saldo;

    public static ContaRetornoDto valueOf(Conta conta) {
        return new ContaRetornoDto(conta.getId(), conta.getBanco().getDescricao(), conta.getAgencia(),
                conta.getNumero(), conta.getDigito(), conta.getSaldo());
    }
}
