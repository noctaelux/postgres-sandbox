package net.providence.postgressandbox.handler;

import net.providence.postgressandbox.exception.ResourceFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class APIExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> HandleValidationException(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public void HandleNotFoundException(){}

    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    @ExceptionHandler(ResourceFoundException.class)
    public Map<String,String> UnprocessableRequest(ResourceFoundException ex){

        Map<String,String> error = new HashMap<>();
        error.put("message",ex.getMessage());
        return error;
    }

}
