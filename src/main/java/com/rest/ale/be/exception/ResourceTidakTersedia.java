package com.rest.ale.be.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceTidakTersedia extends RuntimeException{
    public ResourceTidakTersedia(String message) {
        super(message);
    }

    public ResourceTidakTersedia(String message, Throwable cause) {
        super(message, cause);
    }
}
