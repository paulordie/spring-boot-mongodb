package com.pcorrea.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{ // padrão do compilador de implementação de exceção fazer uma gambiarra no lugar de somente Exception que pede impl
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
