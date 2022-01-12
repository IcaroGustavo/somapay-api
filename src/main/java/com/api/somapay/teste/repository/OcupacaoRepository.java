package com.api.somapay.teste.repository;

import com.api.somapay.teste.model.Ocupacao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Long> {

}
