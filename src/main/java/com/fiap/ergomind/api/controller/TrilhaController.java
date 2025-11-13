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
@RequestMapping("/recurso/trilhas") // Rota: /recurso/trilhas
public class TrilhaController {

    @Autowired
    private TrilhaService trilhaService;

    // GET /recurso/trilhas - Lista todos (Status 200 OK)
    @GetMapping
    public List<TrilhaDeAprendizagem> listar() {
        return trilhaService.listarTodos();
    }

    // GET /recurso/trilhas/{id} - Busca por ID (Status 200 OK ou 404 Not Found)
    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDeAprendizagem> buscarPorId(@PathVariable Long id) {
        // O mapeamento para 404 será tratado pela exceção customizada no Passo 2
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
        // OBS: O tratamento de erro 404 será feito pelo @RestControllerAdvice no Passo 2
        TrilhaDeAprendizagem trilhaAtualizada = trilhaService.atualizar(id, trilha);
        return ResponseEntity.ok(trilhaAtualizada);
    }

    // DELETE /recurso/trilhas/{id} - Remove registro (Status 204 No Content)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        // OBS: O tratamento de erro 404 será feito pelo @RestControllerAdvice no Passo 2
        trilhaService.deletar(id);
    }
}