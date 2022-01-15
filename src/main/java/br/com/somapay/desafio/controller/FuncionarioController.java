package br.com.somapay.desafio.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.somapay.desafio.dto.FuncionarioDto;
import br.com.somapay.desafio.dto.FuncionarioRetornoDto;
import br.com.somapay.desafio.service.FuncionarioService;

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
    public ResponseEntity criarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {

        funcionarioService.criaFuncionario(funcionarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioRetornoDto> editarFuncionario(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id,
            @RequestBody @Valid FuncionarioDto funcionarioDto) {

        FuncionarioRetornoDto funcionarioRetornoSalvo = funcionarioService.editaFuncionario(id, funcionarioDto);

        if (funcionarioRetornoSalvo == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(funcionarioRetornoSalvo, HttpStatus.OK);
    }

}
