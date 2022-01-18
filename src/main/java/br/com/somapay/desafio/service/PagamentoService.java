package br.com.somapay.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.dto.ContaRetornoDto;
import br.com.somapay.desafio.dto.TransferenciaDto;
import br.com.somapay.desafio.exception.ContaNaoEncontradaException;
import br.com.somapay.desafio.exception.ContaOrigemIgualDestinoException;
import br.com.somapay.desafio.exception.SaldoInsuficienteException;

@Service
public class PagamentoService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private TransferenciaService transferenciaService;

    @Autowired
    private EmailService emailService;

    /**
     * Método responsável por verificar saldo de uma conta.
     * @param Id que será verificado a existência. Caso não exista irá disparar a
     *           exceção ContaNaoEncontradaException.
     * @return
     */
    public Double getSaldoContaOrigemById(Long id) {
        verificaContaExiste(id);
        return contaService.getSaldoContaOrigemById(id);
    }

    /**
     * Método responsável por verificar se uma conta existe.
     * 
     * @param id Id que será verificado a existência. Caso não exista irá disparar a
     *           exceção ContaNaoEncontradaException.
     */
    private void verificaContaExiste(Long id) {
        ContaRetornoDto contaOptional = contaService.findContaById(id);

        if (contaOptional != null)
            throw new ContaNaoEncontradaException(id);
    }

    /**
     * Método responsável por criar uma transferência comum.
     * 
     * @param transferenciaDto Dados da transferência. Conta Origem, Conta Destino e
     *                         Valor.
     */
    public void criar(TransferenciaDto transferenciaDto) {

        validarTransferencia(transferenciaDto);
        transferenciaService.SalvaTransferencia(transferenciaDto);
        emailService.enviaEmail(transferenciaDto);

    }

    /**
     * Método responsável por validar uma transferência.
     * 
     * @param transferenciaDto Dados da transferência que será validada.
     */
    private void validarTransferencia(TransferenciaDto transferenciaDto) {
        if (transferenciaDto.getIdContaOrigem() == transferenciaDto.getIdContaDestino())
            throw new ContaOrigemIgualDestinoException();
        if (transferenciaDto.getValor() > contaService.getSaldoContaOrigemById(transferenciaDto.getIdContaOrigem()))
            throw new SaldoInsuficienteException();
    }

}
