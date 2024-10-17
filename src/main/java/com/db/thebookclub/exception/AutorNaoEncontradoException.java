package com.db.thebookclub.exception;

public class AutorNaoEncontradoException extends RuntimeException{
    public AutorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
