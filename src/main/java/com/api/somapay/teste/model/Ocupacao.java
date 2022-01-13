package com.api.somapay.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OCUPACAO", schema = "SIMULADOR")
public class Ocupacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long id;

    @Column(name = "OCUPACAO", nullable = false, length = 100)
    private String ocupacao;

    @Column(name = "SALARIO", nullable = false)
    private Double salario;

    @OneToOne(mappedBy = "ocupacao")
    private Funcionario funcionario;

}
