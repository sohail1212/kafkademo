package com.stackroute.feedbackservice.controllers;


import com.stackroute.feedbackservice.exceptions.FeedbackNotFoundException;
import com.stackroute.feedbackservice.exceptions.InvalidArgumentException;
import com.stackroute.feedbackservice.exceptions.FeedbackAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FeedbackNotFoundException.class)
    public String handleNotFound(Exception e){
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FeedbackAlreadyExistException.class)
    public String handleNotFoundForUser(Exception e){
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidArgumentException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalidArgument(Exception e){
        return "invalid arguments";
    }

}
