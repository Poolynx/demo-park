package com.wesleyRabelo.demoparkapi.exception;

import lombok.Getter;

@Getter
public class VagaDisponivelException extends RuntimeException {

    private String recurso;

    public VagaDisponivelException(String recurso) {
        this.recurso = recurso;
    }
}
