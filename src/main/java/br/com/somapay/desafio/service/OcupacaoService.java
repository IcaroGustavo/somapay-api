package br.com.somapay.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.dto.OcupacaoDto;
import br.com.somapay.desafio.dto.OcupacaoRetornoDto;
import br.com.somapay.desafio.exception.OcupacaoNaoEncontradaException;
import br.com.somapay.desafio.model.Ocupacao;
import br.com.somapay.desafio.repository.OcupacaoRepository;

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

    public OcupacaoRetornoDto getOcupacaoBy(Long id) {
        Optional<Ocupacao> ocupacao = ocupacaoRepository.findById(id);

        if (!ocupacao.isPresent() || ocupacao.isEmpty())
            throw new OcupacaoNaoEncontradaException(id);

        return OcupacaoRetornoDto.valueOf(ocupacao.get());
    }

    public Optional<Ocupacao> getBy(Long id) {
        Optional<Ocupacao> ocupacao = ocupacaoRepository.findById(id);

        if (!ocupacao.isPresent() || ocupacao.isEmpty())
            throw new OcupacaoNaoEncontradaException(id);

        return ocupacao;
    }

    public void criaOcupacao(OcupacaoDto ocupacaoDto) {

        Ocupacao ocupacao = new Ocupacao();
        ocupacao.setOcupacao(ocupacaoDto.getOcupacao());
        ocupacao.setSalario(ocupacaoDto.getSalario());

        ocupacaoRepository.save(ocupacao);
    }

    public OcupacaoRetornoDto editaOcupacao(Long id, OcupacaoDto ocupacaoDto) {

        Ocupacao ocupacao = null;
        Optional<Ocupacao> ocupacaoSalva = ocupacaoRepository.findById(id);

        if (ocupacaoSalva.isPresent()) {

            ocupacao = ocupacaoSalva.get();

            int salarioIgual = ocupacao.getSalario().compareTo(ocupacaoDto.getSalario());

            if (ocupacao.getOcupacao().equals(ocupacaoDto.getOcupacao()) && salarioIgual == 0) {
                return null;
            } else {

                ocupacao.setOcupacao(ocupacaoDto.getOcupacao());
                ocupacao.setSalario(ocupacaoDto.getSalario());
                ocupacao.setId(id);

                ocupacaoRepository.save(ocupacao);
            }
        }

        OcupacaoRetornoDto ocupacaoAtualziada = getOcupacaoBy(id);
        return ocupacaoAtualziada;

    }

    public void deletaOcupacao(Long id) {

        OcupacaoRetornoDto ocupacaoRetornoDtoSalva = getOcupacaoBy(id);

        if (ocupacaoRetornoDtoSalva != null)
            ocupacaoRepository.deleteById(id);
    }

}
