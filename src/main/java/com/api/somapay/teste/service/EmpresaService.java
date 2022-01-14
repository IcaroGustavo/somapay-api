package com.api.somapay.teste.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.api.somapay.teste.dto.EmpresaDto;
import com.api.somapay.teste.dto.EmpresaRetornoDto;
import com.api.somapay.teste.exception.EmpresaNaoEncontradaException;
import com.api.somapay.teste.model.Empresa;
import com.api.somapay.teste.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaRetornoDto> getAll() {
        List<Empresa> listaEmpresa = empresaRepository.findAll();

        if (listaEmpresa.isEmpty())
            return null;

        return listaEmpresa.stream().map(EmpresaRetornoDto::valueOf).collect(Collectors.toList());
    }

    public EmpresaRetornoDto getEmpresaBy(Long id) {
        Optional<Empresa> empresaSalva = empresaRepository.findById(id);

        if (!empresaSalva.isPresent() || empresaSalva.isEmpty())
            throw new EmpresaNaoEncontradaException();

        return EmpresaRetornoDto.valueOf(empresaSalva.get());
    }

    public Optional<Empresa> getBy(Long id) {
        Optional<Empresa> empresaSalva = empresaRepository.findById(id);

        if (!empresaSalva.isPresent() || empresaSalva.isEmpty())
            throw new EmpresaNaoEncontradaException();

        return empresaSalva;
    }

    public void criaEmpresa(@Valid EmpresaDto empresaDto) {

        Empresa empresa = new Empresa();
        empresa.setCnpj(empresaDto.getCnpj());
        empresa.setNomeFantasia(empresaDto.getNomeFantasia());
        empresa.setEmail(empresaDto.getEmail());
        empresa.setTelefone(empresaDto.getTelefone());

        empresaRepository.save(empresa);
    }

    public EmpresaRetornoDto editaEmpresa(Long id, EmpresaDto empresaDto) {

        Empresa empresa = null;
        Optional<Empresa> empresaSalva = empresaRepository.findById(id);

        if (empresaSalva.isPresent()) {
            empresa = empresaSalva.get();

            empresa.setCnpj(empresaDto.getCnpj());
            empresa.setNomeFantasia(empresaDto.getEmail());
            empresa.setEmail(empresaDto.getEmail());
            empresa.setTelefone(empresaDto.getTelefone());

            empresaRepository.save(empresa);
        }

        EmpresaRetornoDto empresaAtualizada = getEmpresaBy(id);
        return empresaAtualizada;
    }

    public void deletaEmpresa(Long id) {
        Optional<Empresa> empresaSalva = getBy(id);

        if (empresaSalva != null)
            empresaRepository.deleteById(id);
    }

}
