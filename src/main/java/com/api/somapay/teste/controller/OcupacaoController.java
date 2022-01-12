package com.api.somapay.teste.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.api.somapay.teste.dto.OcupacaoDto;
import com.api.somapay.teste.dto.OcupacaoRetornoDto;
import com.api.somapay.teste.service.OcupacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ocupacoes")
public class OcupacaoController {

    @Autowired
    private OcupacaoService ocupacaoService;

    @GetMapping
    public ResponseEntity<List<OcupacaoRetornoDto>> getContatos() {
        List<OcupacaoRetornoDto> listaOcupacoes = ocupacaoService.getAll();

        if (listaOcupacoes == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listaOcupacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OcupacaoRetornoDto> getOcupacaoBy(
            @PathVariable @Min(value = 1, message = "Id inválido!") long id) {

        return new ResponseEntity<>(ocupacaoService.getOcupacaoBy(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criarOcupacao(@RequestBody @Valid OcupacaoDto ocupacaoDto) {
        
        ocupacaoService.criaOcupacao(ocupacaoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
