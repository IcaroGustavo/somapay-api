package br.com.somapay.desafio.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "TRANSFERENCIA")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(name = "DATA_TRANSFERENCIA", updatable = false, nullable = false)
    private LocalDateTime dataTransferencia;

    @CreationTimestamp
    @Column(name = "DATA_CRIACAO", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "VALOR", updatable = false, nullable = false)
    private double valor;

    @ManyToOne
    @JoinColumn(name = "CONTA_ORIGEM_FK", updatable = false, nullable = false)
    private Conta contaOrigem;

    @ManyToOne
    @JoinColumn(name = "CONTA_DESTINO_FK", updatable = false, nullable = false)
    private Conta contaDestino;
}
