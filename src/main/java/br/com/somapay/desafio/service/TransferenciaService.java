package br.com.somapay.desafio.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.somapay.desafio.dto.TransferenciaDto;
import br.com.somapay.desafio.exception.ContaDestinoNaoEncontradaException;
import br.com.somapay.desafio.exception.ContaOrigemNaoEncontradaException;
import br.com.somapay.desafio.model.Conta;
import br.com.somapay.desafio.model.Transferencia;
import br.com.somapay.desafio.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private ContaService contaService;

    /**
     * Método responsável em salvar uma transferência.
     * 
     * @param transferenciaDto
     * @return
     */
    @Transactional
    public void SalvaTransferencia(TransferenciaDto transferenciaDto) {
        Conta contaOrigem = contaService.findById(transferenciaDto.getIdContaOrigem())
                .orElseThrow(ContaOrigemNaoEncontradaException::new);
        Conta contaDestino = contaService.findById(transferenciaDto.getIdContaDestino())
                .orElseThrow(ContaDestinoNaoEncontradaException::new);

        Transferencia transferencia = new Transferencia();
        transferencia.setDataTransferencia(LocalDateTime.now());
        transferencia.setValor(transferenciaDto.getValor());
        transferencia.setContaOrigem(contaOrigem);
        transferencia.setContaDestino(contaDestino);

        criaDespesa(contaOrigem, transferenciaDto.getValor());
        criaReceita(contaDestino, transferenciaDto.getValor());

        transferenciaRepository.save(transferencia);
    }

    private void criaReceita(Conta contaDestino, double valor) {
        contaService.criaReceita(contaDestino, valor);
    }

    private void criaDespesa(Conta contaOrigem, double valor) {
        contaService.criaDespesa(contaOrigem, valor);
    }

}
