package com.blog.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionHelper {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), null, null);
    }

    @ExceptionHandler(value = ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<?> notFoundExceptionHandler(ChangeSetPersister.NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), null, null);
    }
}
