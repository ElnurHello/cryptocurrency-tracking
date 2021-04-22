package app.onoff.cryptocurrencytracking.controller;

import app.onoff.cryptocurrencytracking.exception.CryptocurrencyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CryptocurrencyExceptionHandler {
    @ExceptionHandler(CryptocurrencyNotFoundException.class)
    public String handleCryptcurrencyNotFoundException(CryptocurrencyNotFoundException e) {
        return String.format("ERROR: %s", e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return String.format("ERROR: %s", "JSON body is not in correct format");
    }
}