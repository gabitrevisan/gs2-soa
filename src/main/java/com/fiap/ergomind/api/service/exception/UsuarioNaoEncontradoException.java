package com.fiap.ergomind.api.service.exception;

// Exceção customizada para erros de 404 Not Found no recurso Usuario
public class UsuarioNaoEncontradoException extends RuntimeException {
    
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}