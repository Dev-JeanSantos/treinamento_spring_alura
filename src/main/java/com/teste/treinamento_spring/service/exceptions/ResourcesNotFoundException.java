package com.teste.treinamento_spring.service.exceptions;

public class ResourcesNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourcesNotFoundException(String msg) {
        super(msg);
    }
}
