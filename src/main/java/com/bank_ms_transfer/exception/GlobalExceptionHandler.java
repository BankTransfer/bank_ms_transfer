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
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestExceptionResponse handleServiceExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("Service error, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI())
                .code("1")
                .message(ex.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getField() + ": " + error.getDefaultMessage())
                        .collect(Collectors.joining("; ")))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidPanException.class)
    public RestExceptionResponse handleServiceExceptions(InvalidPanException ex, HttpServletRequest request) {
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
    public RestExceptionResponse handleServiceExceptions(InvalidAmountException ex, HttpServletRequest request) {
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

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public RestExceptionResponse handleUnexpectedErrors(RuntimeException ex, HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("Unexpected error, status: {}, message: {}", processKey, ex.getMessage(), ex);
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .path(request.getRequestURI())
                .code("999")
                .message("Unexpected error occurred: " + ex.getMessage())
                .build();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public RestExceptionResponse handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("User not found, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .code("4")
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public RestExceptionResponse handleUserAlreadyExists(UserAlreadyExistsException ex,
                                                         HttpServletRequest request) {
        String processKey = UUID.randomUUID().toString();
        log.error("User already exists, status: {}, message: {}", processKey, ex.getMessage());
        return RestExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value()) // 409
                .path(request.getRequestURI())
                .code("5")
                .message(ex.getMessage())
                .build();
    }

}
