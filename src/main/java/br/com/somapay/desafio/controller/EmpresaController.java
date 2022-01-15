package br.com.somapay.desafio.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.somapay.desafio.dto.EmpresaDto;
import br.com.somapay.desafio.dto.EmpresaRetornoDto;
import br.com.somapay.desafio.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<EmpresaRetornoDto>> getEmpresas() {
        List<EmpresaRetornoDto> listaEmpresas = empresaService.getAll();

        if (listaEmpresas.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<EmpresaRetornoDto>>(listaEmpresas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaRetornoDto> getEmpresaBy(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id) {
        return new ResponseEntity<>(empresaService.getEmpresaBy(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criarEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
        empresaService.criaEmpresa(empresaDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaRetornoDto> editarEmpresa(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id,
            @RequestBody @Valid EmpresaDto empresaDto) {

        EmpresaRetornoDto empresaRetornoSalva = empresaService.editaEmpresa(id, empresaDto);

        if (empresaRetornoSalva == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(empresaRetornoSalva, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletarEmpresa(@PathVariable @Min(value = 1, message = "Id inválido!") Long id) {
        empresaService.deletaEmpresa(id);
    }
}
