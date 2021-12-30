package com.salad.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler({
          VegetableNotFoundException.class,
          SaladNotFoundException.class,
          IngredientNotFoundException.class
  })
  public ResponseEntity<ErrorMessage> notFoundException(Exception ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        new Date(),
        ex.getMessage(),
        request.getDescription(false)
    );
    
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }


}
