package br.com.somapay.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.somapay.desafio.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
