package br.com.somapay.desafio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.somapay.desafio.enums.SituacaoFuncionarioEnum;
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

    @Column(name = "SITUACAO_FUNCIONARIO", nullable = true)
    private SituacaoFuncionarioEnum situacaoFuncionario;

    @CreationTimestamp
    @Column(name = "DATA_ADMISSAO", updatable = false, nullable = false)
    private Date dataAdmissao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OCUPACAO_FK", updatable = false, nullable = false)
    private Ocupacao ocupacao;

    @ManyToOne
    @JoinColumn(name = "EMPRESA_FK", updatable = false, nullable = false)
    private Empresa empresa;

}
