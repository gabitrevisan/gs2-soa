package com.fiap.ergomind.api.service.exception;

// Exceção para erros de 404 (Not Found)
public class UsuarioNaoEncontradoException extends RuntimeException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }
}