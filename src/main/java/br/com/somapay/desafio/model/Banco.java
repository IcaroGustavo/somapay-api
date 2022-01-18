package br.com.somapay.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BANCO")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DESCRICAO")
    private String descricao;
}
