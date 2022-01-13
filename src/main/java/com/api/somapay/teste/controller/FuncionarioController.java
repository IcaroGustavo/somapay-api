package com.api.somapay.teste.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.api.somapay.teste.dto.FuncionarioDto;
import com.api.somapay.teste.dto.FuncionarioRetornoDto;
import com.api.somapay.teste.service.FuncionarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioRetornoDto>> getFuncionarios() {

        List<FuncionarioRetornoDto> listaFuncionario = funcionarioService.getAll();

        if (listaFuncionario.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<FuncionarioRetornoDto>>(listaFuncionario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioRetornoDto> getFuncionarioBy(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id) {

        return new ResponseEntity<>(funcionarioService.getFuncionarioBy(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFuncionario(@PathVariable @Min(value = 1, message = "Id inválido!") Long id) {

        funcionarioService.deletaFuncionario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criarFuncionario(@RequestBody @Valid FuncionarioDto ocupacaoDto) {

        funcionarioService.criaFuncionario(ocupacaoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
