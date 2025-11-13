package com.fiap.ergomind.api.service.exception;

// Exceção customizada para erros de 404 Not Found no recurso Trilha
public class TrilhaNaoEncontradaException extends RuntimeException {
    
    public TrilhaNaoEncontradaException(String message) {
        super(message);
    }
}