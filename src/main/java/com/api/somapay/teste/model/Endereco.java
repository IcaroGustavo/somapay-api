package com.api.somapay.teste.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;
    @Column(name = "LOGRADOURO", nullable = false, length = 100)
    private String logradouro;
    @Column(name = "COMPLEMENTO", nullable = true, length = 100)
    private String complemento;
    @Column(name = "BAIRRO", nullable = false, length = 100)
    private String bairro;
    @Column(name = "LOCALIDADE", nullable = false, length = 100)
    private String localidade;
    @Column(name = "UF", nullable = false, length = 2)
    private String uf;
    @Column(name = "NUMERO", nullable = true, length = 10)
    private String numero;

    /**
     * GETTERS AND SETTERS
     */
    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return this.localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
