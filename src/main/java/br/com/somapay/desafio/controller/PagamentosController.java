package br.com.somapay.desafio.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.somapay.desafio.dto.TransferenciaDto;
import br.com.somapay.desafio.service.PagamentoService;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentosController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<Double> getSaldoContaOrigemById(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id) {
        return new ResponseEntity<>(pagamentoService.getSaldoContaOrigemById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid TransferenciaDto transferenciaDto) {
        pagamentoService.criar(transferenciaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
