package br.com.somapay.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.somapay.desafio.model.Banco;
import br.com.somapay.desafio.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByAgenciaAndNumeroAndDigitoAndBanco(String agencia, String numero, String digito, Banco banco);
}
