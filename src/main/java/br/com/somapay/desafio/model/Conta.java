package br.com.somapay.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "AGENCIA")
    private String agencia;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DIGITO")
    private String digito;

    @Column(name = "SALDO")
    private Double Saldo;

    @ManyToOne
    @JoinColumn(name = "BANCO_FK")
    private Banco banco;
}
