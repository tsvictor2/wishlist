package ru.raiffeisen.wishlist.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.raiffeisen.wishlist.controller.model.ErrorResponse;

import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String ERROR_INVALID_REQUEST = "INVALID_REQUEST";

    @ExceptionHandler
    @ResponseStatus(BAD_REQUEST)
    ErrorResponse onValidationException(MethodArgumentNotValidException e) {
        log.warn("Bad request processing exception: {}", e.getMessage());
        String message = Optional.ofNullable(e.getFieldError())
                .map(x -> String.format("%s: %s", x.getField(), x.getDefaultMessage())).orElse("");
        return new ErrorResponse(ERROR_INVALID_REQUEST, message);
    }
}
