package com.dcx.ufpb.jefferson.payment_service.resources.exceptions;


import com.dcx.ufpb.jefferson.payment_service.services.exceptions.DatabaseException;
import com.dcx.ufpb.jefferson.payment_service.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//Essa classe interceptar as expcetions que acontecerem para que seja possivel que ela executar um possivel tratamento
@ControllerAdvice
public class ResourceExceptionHandler {
    //Essa anotation permite que esse metodo possa interceptar qualquer exception do tipo 'ResourceNotFoundException' e faz o tratamento que tiver dentro do corpo do metodo
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; //HttpStatus é um enum do springboot e para pegar o valor é necessario pedir o value() do enum, neste caso é o 404
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        //.status() retorna permite retornar um codigo personalizado no caso a variavel status que está acima
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST; //HttpStatus é um enum do springboot e para pegar o valor é necessario pedir o value() do enum, neste caso é o 400
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        //.status() retorna permite retornar um codigo personalizado no caso a variavel status que está acima
        return ResponseEntity.status(status).body(err);
    }

}
