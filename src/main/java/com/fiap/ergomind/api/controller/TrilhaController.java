package com.fiap.ergomind.api.controller;

import com.fiap.ergomind.api.model.TrilhaDeAprendizagem;
import com.fiap.ergomind.api.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso/trilhas")
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    // GET /recurso/trilhas - Lista todas (Status 200 OK)
    @GetMapping
    public List<TrilhaDeAprendizagem> listar() {
        return trilhaService.listarTodos();
    }

    // GET /recurso/trilhas/{id} - Busca por ID (Status 200 OK ou 404 Not Found)
    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDeAprendizagem> buscarPorId(@PathVariable Long id) {
        return trilhaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /recurso/trilhas - Cria registro (Status 201 Created)
    @PostMapping
    public ResponseEntity<TrilhaDeAprendizagem> cadastrar(@Valid @RequestBody TrilhaDeAprendizagem trilha) {
        TrilhaDeAprendizagem novaTrilha = trilhaService.criar(trilha);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTrilha);
    }

    // PUT /recurso/trilhas/{id} - Atualiza registro (Status 200 OK ou 404 Not Found)
    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDeAprendizagem> atualizar(@PathVariable Long id, @Valid @RequestBody TrilhaDeAprendizagem trilha) {
        // Se não encontrar, o Service lança a exceção que é tratada pelo CustomExceptionHandler
        TrilhaDeAprendizagem trilhaAtualizada = trilhaService.atualizar(id, trilha);
        return ResponseEntity.ok(trilhaAtualizada);
    }

    // DELETE /recurso/trilhas/{id} - Remove registro (Status 204 No Content ou 404 Not Found)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // Se não encontrar, o Service lança a exceção que é tratada pelo CustomExceptionHandler
        trilhaService.deletar(id);
    }
}