package br.com.somapay.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.dto.FuncionarioDto;
import br.com.somapay.desafio.dto.FuncionarioRetornoDto;
import br.com.somapay.desafio.exception.EmpresaNaoEncontradaException;
import br.com.somapay.desafio.exception.FuncionarioNaoEncontradoException;
import br.com.somapay.desafio.exception.OcupacaoNaoEncontradaException;
import br.com.somapay.desafio.model.Empresa;
import br.com.somapay.desafio.model.Funcionario;
import br.com.somapay.desafio.model.Ocupacao;
import br.com.somapay.desafio.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private OcupacaoService ocupacaoService;

    @Autowired
    private EmpresaService empresaService;

    public List<FuncionarioRetornoDto> getAll() {

        List<Funcionario> listaFuncionarios = funcionarioRepository.findAll();

        if (listaFuncionarios.isEmpty())
            return null;

        return listaFuncionarios.stream().map(FuncionarioRetornoDto::valueOf).collect(Collectors.toList());
    }

    public FuncionarioRetornoDto getFuncionarioBy(Long id) {

        Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(id);

        if (!funcionarioSalvo.isPresent() || funcionarioSalvo.isEmpty())
            throw new FuncionarioNaoEncontradoException();

        return FuncionarioRetornoDto.valueOf(funcionarioSalvo.get());
    }

    public void deletaFuncionario(Long id) {
        FuncionarioRetornoDto funcionarioSalvo = getFuncionarioBy(id);

        if (funcionarioSalvo != null)
            funcionarioRepository.deleteById(id);
    }

    public void criaFuncionario(FuncionarioDto funcionarioDto) {

        Ocupacao ocupacao = ocupacaoService.getBy(funcionarioDto.getIdOcupacao())
                .orElseThrow(OcupacaoNaoEncontradaException::new);

        Empresa empresa = empresaService.getBy(funcionarioDto.getIdEmpresa())
                .orElseThrow(EmpresaNaoEncontradaException::new);

        Funcionario funcionario = new Funcionario();
        funcionario.setFuncionario(funcionarioDto.getFuncionario());
        funcionario.setDataAdmissao(funcionarioDto.getDataAdmissao());
        funcionario.setOcupacao(ocupacao);
        funcionario.setEmpresa(empresa);

        funcionarioRepository.save(funcionario);
    }

    public FuncionarioRetornoDto editaFuncionario(Long id, FuncionarioDto funcionarioDto) {

        Funcionario funcionario = null;
        Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(id);

        if (funcionarioSalvo.isPresent()) {

            funcionario = funcionarioSalvo.get();

            Ocupacao ocupacao = ocupacaoService.getBy(funcionarioDto.getIdOcupacao())
                    .orElseThrow(OcupacaoNaoEncontradaException::new);

            Empresa empresa = empresaService.getBy(funcionarioDto.getIdEmpresa())
                    .orElseThrow(EmpresaNaoEncontradaException::new);

            funcionario.setFuncionario(funcionarioDto.getFuncionario());
            funcionario.setDataAdmissao(funcionarioDto.getDataAdmissao());
            funcionario.setOcupacao(ocupacao);
            funcionario.setEmpresa(empresa);
            funcionarioRepository.save(funcionario);
        }

        FuncionarioRetornoDto funcionarioAtualizado = getFuncionarioBy(id);
        return funcionarioAtualizado;
    }
}
