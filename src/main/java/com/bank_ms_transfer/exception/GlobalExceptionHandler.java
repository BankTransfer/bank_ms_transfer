package com.bank_ms_transfer.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestExceptionResponse handleServiceExceptions(MethodArgumentNotValidException ex,
                                                          HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("Service error, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("1")
                .message(ex.getFieldError().getDefaultMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPanException.class)
    public RestExceptionResponse handleServiceExceptions(InvalidPanException ex,
                                                          HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("Service error, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("2")
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidAmountException.class)
    public RestExceptionResponse handleServiceExceptions(InvalidAmountException ex,
                                                         HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("Service error, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("3")
                .message(ex.getMessage())
                .build();
    }

}
