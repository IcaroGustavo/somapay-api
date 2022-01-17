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

import br.com.somapay.desafio.dto.UsuarioDto;
import br.com.somapay.desafio.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getUsuario() {
        List<UsuarioDto> listaUsuarios = usuarioService.getAll();

        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioBy(@PathVariable @Min(value = 1, message = "Id inválido!") Long id) {

        return new ResponseEntity<>(usuarioService.getUsuarioBy(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioDto UsuarioDto) {

        usuarioService.criaUsuario(UsuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> editarUsuario(
            @PathVariable @Min(value = 1, message = "Id inválido!") Long id,
            @RequestBody @Valid UsuarioDto UsuarioDto) {

        UsuarioDto UsuarioRetornoSalva = usuarioService.editaUsuario(id, UsuarioDto);

        if (UsuarioRetornoSalva == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(UsuarioRetornoSalva, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable @Min(value = 1, message = "Id inválido!") Long id) {
        usuarioService.deletaUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
