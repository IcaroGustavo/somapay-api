package br.com.somapay.desafio.dto;

import java.time.LocalDateTime;

import br.com.somapay.desafio.model.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransferenciaRetornoDto {

    private Long id;
    private LocalDateTime dataTransferencia;
    private double valor;
    private ContaRetornoDto contaDestino;

    public static TransferenciaRetornoDto valueOf(Transferencia transferencia) {
        return new TransferenciaRetornoDto(transferencia.getId(), transferencia.getDataTransferencia(),
                transferencia.getValor(), ContaRetornoDto.valueOf(transferencia.getContaDestino()));
    }
}
