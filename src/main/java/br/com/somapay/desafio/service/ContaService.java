package br.com.somapay.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.dto.ContaRetornoDto;
import br.com.somapay.desafio.exception.ContaNaoEncontradaException;
import br.com.somapay.desafio.model.Conta;
import br.com.somapay.desafio.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public ContaRetornoDto findContaById(Long id) {
        Optional<Conta> contaSalva = contaRepository.findById(id);

        if (contaSalva.isPresent()) {
            return ContaRetornoDto.valueOf(contaSalva.get());
        } else {
            throw new ContaNaoEncontradaException();
        }

    }

    public Double getSaldoContaOrigemById(Long id) {
        ContaRetornoDto contaRetornoDto = findContaById(id);

        return contaRetornoDto.getSaldo();
    }

    public Optional<Conta> findById(Long id) {
        Optional<Conta> contaSalva = contaRepository.findById(id);

        if (contaSalva.isPresent()) {
            return contaSalva;
        } else {
            throw new ContaNaoEncontradaException();
        }
    }

    public void criaReceita(Conta contaDestino, double valor) {
        Conta conta = null;
        Optional<Conta> contaSalva = contaRepository.findById(contaDestino.getId());

        if (contaSalva.isPresent()) {

            conta = contaSalva.get();

            Double saldo = contaDestino.getSaldo() - valor;
            conta.setSaldo(saldo);

            contaRepository.save(conta);
        }
    }

    public void criaDespesa(Conta contaOrigem, double valor) {
        Conta conta = null;
        Optional<Conta> contaSalva = contaRepository.findById(contaOrigem.getId());

        if (contaSalva.isPresent()) {

            conta = contaSalva.get();

            Double saldo = contaOrigem.getSaldo() + valor;
            conta.setSaldo(saldo);

            contaRepository.save(conta);
        }
    }

}
