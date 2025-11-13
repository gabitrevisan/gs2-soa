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
@RequestMapping("/recurso/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET /recurso/usuarios - Lista todos (Status 200 OK)
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    // GET /recurso/usuarios/{id} - Busca por ID (Status 200 OK ou 404 Not Found)
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /recurso/usuarios - Cria registro (Status 201 Created)
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    // PUT /recurso/usuarios/{id} - Atualiza registro (Status 200 OK ou 404 Not Found)
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        // Se não encontrar, o Service lança a exceção que é tratada pelo CustomExceptionHandler
        Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    // DELETE /recurso/usuarios/{id} - Remove registro (Status 204 No Content ou 404 Not Found)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Se não encontrar, o Service lança a exceção que é tratada pelo CustomExceptionHandler
        usuarioService.deletar(id);
    }
}