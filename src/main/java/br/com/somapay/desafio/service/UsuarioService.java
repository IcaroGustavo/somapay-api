package br.com.somapay.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.somapay.desafio.dto.UsuarioDto;
import br.com.somapay.desafio.exception.UsuarioNaoEncontradoException;
import br.com.somapay.desafio.model.Usuario;
import br.com.somapay.desafio.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public List<UsuarioDto> getAll() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();

        if (listaUsuarios.isEmpty()) {
            return null;
        } else {
            return listaUsuarios.stream().map(UsuarioDto::valueOf).collect(Collectors.toList());
        }

    }

    public UsuarioDto getUsuarioBy(Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent() || usuario.isEmpty())
            throw new UsuarioNaoEncontradoException();

        return UsuarioDto.valueOf(usuario.get());
    }

    public UsuarioDto editaUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = null;
        Optional<Usuario> usuarioSalvo = usuarioRepository.findById(id);

        if (usuarioSalvo.isPresent()) {

            usuario = usuarioSalvo.get();

            if (usuario.getLogin().equals(usuarioDto.getLogin()) && usuario.getSenha().equals(usuarioDto.getSenha())) {
                return null;
            } else {

                usuario.setLogin(usuarioDto.getLogin());
                usuario.setSenha(encoder.encode(usuarioDto.getSenha()));
                usuario.setId(id);

                usuarioRepository.save(usuario);
            }
        }

        UsuarioDto usuarioAtualizado = getUsuarioBy(id);
        return usuarioAtualizado;
    }

    public void deletaUsuario(Long id) {

        UsuarioDto usuarioSalvo = getUsuarioBy(id);

        if (usuarioSalvo != null)
            usuarioRepository.deleteById(id);
    }

    public void criaUsuario(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();

        usuario.setLogin(usuarioDto.getLogin());
        usuario.setSenha(encoder.encode(usuarioDto.getSenha()));

        usuarioRepository.save(usuario);
    }

}
