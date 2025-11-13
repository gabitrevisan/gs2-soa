package com.fiap.ergomind.api.controller;

import com.fiap.ergomind.api.service.exception.TrilhaNaoEncontradaException;
import com.fiap.ergomind.api.service.exception.UsuarioNaoEncontradoException;
import io.swagger.v3.oas.annotations.Hidden; // NOVO IMPORT NECESSÁRIO
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class CustomExceptionHandler {

    // Trata erros de Bean Validation (@NotBlank, @Email, etc.) -> Status 400 Bad Request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de Validação: " + errorMessage);
    }

    // Trata a exceção customizada de Usuario Não Encontrado -> Status 404 Not Found
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Object> handleUsuarioNotFound(UsuarioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); // Status 404
    }

    // Trata a exceção customizada de Trilha Não Encontrada -> Status 404 Not Found
    @ExceptionHandler(TrilhaNaoEncontradaException.class)
    public ResponseEntity<Object> handleTrilhaNotFound(TrilhaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()); // Status 404
    }

    // Tratamento de erro genérico para qualquer outra falha não mapeada -> Status 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor: " + ex.getMessage());
    }
}