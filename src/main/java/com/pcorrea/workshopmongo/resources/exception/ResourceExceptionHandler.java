package com.pcorrea.workshopmongo.resources.exception;

import com.pcorrea.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //responsavel por tratar possiveis erros nas exceçoes
public class ResourceExceptionHandler { //objectNotFoundException para ser equivalente a excecao do service.exception e quando estourar a excecao 'e' retorna o objectnotfoundexception

    @ExceptionHandler(ObjectNotFoundException.class) //notação padrão para funcionar a personalização de exceção
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request){ //HttpServletRequest request ->>>> getRequestURI
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(), "Não encontrado",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
