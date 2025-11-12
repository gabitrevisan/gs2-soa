package com.fiap.ergomind.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    // Trata erros de Bean Validation (campos em branco, emails inválidos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Mapeia os erros de validação em um formato legível
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        // Retorna 400 Bad Request com a mensagem clara do erro
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de Validação: " + errorMessage);
    }

    // Exemplo de como tratar exceções customizadas (ex: "Trilha não encontrada")
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); // Status 404
    }
}