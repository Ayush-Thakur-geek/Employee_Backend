package com.example.demo.Exceptions;

import com.example.demo.Model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employNotFoundHandler(EmployeeNotFoundException ex) {
        ErrorMessage errorMessage =
                new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception ex) {
        ErrorMessage errorMessage =
                new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return errorMessage;
    }
}
