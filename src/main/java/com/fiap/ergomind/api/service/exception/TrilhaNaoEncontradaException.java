package com.fiap.ergomind.api.service.exception;

// Exceção para erros de 404 (Not Found)
public class TrilhaNaoEncontradaException extends RuntimeException {
    public TrilhaNaoEncontradaException(String message) {
        super(message);
    }
}