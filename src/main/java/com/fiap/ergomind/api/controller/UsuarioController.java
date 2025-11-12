package com.fiap.ergomind.api.controller;

import com.fiap.ergomind.api.model.Usuario;
import com.fiap.ergomind.api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso/usuarios") // Rota: /recurso
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // GET /recurso/usuarios - Lista todos
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    // GET /recurso/usuarios/{id} - Busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Status 404
    }

    // POST /recurso/usuarios - Cria registro
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario); // Status 201
    }

    // PUT /recurso/usuarios/{id} - Atualiza registro
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
            return ResponseEntity.ok(usuarioAtualizado); // Status 200
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Status 404
        }
    }

    // DELETE /recurso/usuarios/{id} - Remove registro
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Status 204
    public void deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
    }
}