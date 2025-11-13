package com.fiap.ergomind.api.service;

import com.fiap.ergomind.api.model.Usuario;
import com.fiap.ergomind.api.repository.UsuarioRepository;
import com.fiap.ergomind.api.service.exception.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setAreaAtuacao(usuarioAtualizado.getAreaAtuacao());
            usuario.setNivelCarreira(usuarioAtualizado.getNivelCarreira());
            // Mantém a data de cadastro original
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado para atualização (ID: " + id + ")."));
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado para exclusão (ID: " + id + ").");
        }
        usuarioRepository.deleteById(id);
    }
}