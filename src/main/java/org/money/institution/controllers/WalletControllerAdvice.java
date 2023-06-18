package org.money.institution.controllers;

import org.money.institution.views.ErrorResponseView;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface WalletControllerAdvice {

    ResponseEntity<ErrorResponseView> handleBalanceException(Exception exception, HttpServletRequest request);
    ResponseEntity<ErrorResponseView> handleNotFoundException(Exception exception, HttpServletRequest request);

}
