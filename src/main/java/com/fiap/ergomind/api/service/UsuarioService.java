package com.fiap.ergomind.api.service;

import com.fiap.ergomind.api.model.Usuario;
import com.fiap.ergomind.api.repository.UsuarioRepository;
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

    public Usuario criar(Usuario usuario) {
        // Regra de Negócio: Aqui poderia haver a verificação de senha, criptografia, etc.
        return usuarioRepository.save(usuario);
    }
    
    // READ por ID (necessário para PUT/DELETE/GET)
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // UPDATE
    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            // Outras atualizações
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario não encontrado para atualização.")); 
        // Lidar com exceção de forma customizada, conforme requisito de tratamento de erros.
    }

    // DELETE
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}