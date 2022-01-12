package com.api.somapay.teste.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.api.somapay.teste.dto.OcupacaoDto;
import com.api.somapay.teste.dto.OcupacaoRetornoDto;
import com.api.somapay.teste.exception.OcupacaoNaoEncontradaException;
import com.api.somapay.teste.model.Ocupacao;
import com.api.somapay.teste.repository.OcupacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcupacaoService {

    @Autowired
    private OcupacaoRepository ocupacaoRepository;

    public List<OcupacaoRetornoDto> getAll() {
        List<Ocupacao> listaOcupacoes = ocupacaoRepository.findAll();

        if (listaOcupacoes.isEmpty()) {
            return null;
        } else {
            return listaOcupacoes.stream().map(OcupacaoRetornoDto::valueOf).collect(Collectors.toList());
        }
    }

    public OcupacaoRetornoDto getOcupacaoBy(long id) {
        Optional<Ocupacao> ocupacao = ocupacaoRepository.findById(id);

        if (ocupacao.isEmpty())
            throw new OcupacaoNaoEncontradaException(id);

        return OcupacaoRetornoDto.valueOf(ocupacao.get());
    }

    public void criaOcupacao(OcupacaoDto ocupacaoDto) {

        Ocupacao ocupacao = new Ocupacao();
        ocupacao.setOcupacao(ocupacaoDto.getOcupacao());
        ocupacao.setSalario(ocupacaoDto.getSalario());

        ocupacaoRepository.save(ocupacao);
    }

}
