package org.money.institution.controllers;

import org.money.institution.exceptions.*;
import org.money.institution.views.ErrorResponseView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WalletControllerAdviceImpl implements WalletControllerAdvice {

    @ExceptionHandler(BalanceException.class)
    @Override
    public ResponseEntity<ErrorResponseView> handleBalanceException(Exception exception, HttpServletRequest request) {
        String message = exception.getMessage();

        exception.printStackTrace();

        return handleException(message, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    @Override
    public ResponseEntity<ErrorResponseView> handleNotFoundException(Exception exception, HttpServletRequest request) {
        String message = exception.getMessage();

        exception.printStackTrace();

        return handleException(message, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponseView> handleException(String message, HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus)
                .body(ErrorResponseView.from(message));
    }

}
