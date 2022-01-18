package br.com.somapay.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.somapay.desafio.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}
