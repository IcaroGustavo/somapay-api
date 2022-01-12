package com.api.somapay.teste.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.api.somapay.teste.enums.SituacaoFuncionarioEnum;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long id;

    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String funcionario;

    @Column(name = "SITUACAO_FUNCIONARIO", nullable = false)
    private SituacaoFuncionarioEnum situacaoFuncionario;

    @CreationTimestamp
    @Column(name = "DATA_ADMISSAO", updatable = false, nullable = false)
    private Date dataAdmissao;

    @Embedded
    private Endereco endereco;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCUPACAO_FK", updatable = false, nullable = false)
    private Ocupacao ocupacao;

    @ManyToOne
    @JoinColumn(name = "EMPRESA_FK", updatable = false, nullable = false)
    private Empresa empresa;

    /** 
     * GET AND SET
    */
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
