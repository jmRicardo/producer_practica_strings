package com.jmr.producer.producer_practica.producer_practica_strings.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StockNotFound extends RuntimeException{

    public StockNotFound(String message) {
        super(message);
        log.error(message);
    }
}
