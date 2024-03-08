package com.wesleyRabelo.demoparkapi.exception;
import lombok.Getter;

@Getter
public class ReciboNotFoundException extends RuntimeException {

    private String recibo;
    public ReciboNotFoundException(String recibo) {
        this.recibo = recibo;
    }
}
