package org.zloebok.financialbudget.exception.user.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zloebok.financialbudget.exception.details.ExceptionDetails;
import org.zloebok.financialbudget.exception.user.UserConstraintValidationException;
import org.zloebok.financialbudget.exception.user.UserNotFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDetails> UserNotFoundExceptionHandling
            (UserNotFoundException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .message(exception.getMessage())
                .exceptionName(exception.getClass().getSimpleName())
                .httpStatus(HttpStatus.NOT_FOUND)
                .time(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
    }

    @ExceptionHandler(UserConstraintValidationException.class)
    public ResponseEntity<ExceptionDetails> UserConstraintValidationExceptionHandling
            (UserConstraintValidationException exception) {
        ExceptionDetails exceptionDetails = null;
        TransactionSystemException transactionSystemException = null;

        if (exception.getCause() != null) {
            transactionSystemException = (TransactionSystemException) exception.getCause();

            if (transactionSystemException.getRootCause() instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException =
                        (ConstraintViolationException) transactionSystemException.getRootCause();

                exceptionDetails = exceptionDetails.builder()
                        .message(exception.getMessage() + " | Cause: " + constraintViolationException.getMessage())
                        .exceptionName(exception.getClass().getSimpleName())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .time(LocalDateTime.now())
                        .build();

                return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
            }
        }
        
        exceptionDetails = exceptionDetails.builder()
                .message(exception.getMessage())
                .exceptionName(exception.getClass().getSimpleName())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .time(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDetails> HttpMessageNotReadableExceptionHandling
            (HttpMessageNotReadableException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .message(exception.getMessage())
                .exceptionName(exception.getClass().getSimpleName())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .time(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, exceptionDetails.getHttpStatus());
    }
}
