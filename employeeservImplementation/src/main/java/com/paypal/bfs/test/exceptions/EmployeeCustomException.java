package com.paypal.bfs.test.exceptions;

import com.paypal.bfs.test.enums.ErrorCode;
import com.paypal.bfs.test.enums.ResponseStatus;
import com.paypal.bfs.test.model.ErrorRequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeCustomException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    protected ResponseEntity<ErrorRequestResponse> badRequestException(final BadRequestException ex) {

        return new ResponseEntity<ErrorRequestResponse>(
                new ErrorRequestResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ResponseStatus.FAILURE.name()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RecordNotFoundException.class})
    protected ResponseEntity<ErrorRequestResponse> recordNotFoundException(final RecordNotFoundException ex) {

        return new ResponseEntity<ErrorRequestResponse>(
                new ErrorRequestResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), ResponseStatus.FAILURE.name()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity<ErrorRequestResponse> applicationException(final ApplicationException ex) {

        return new ResponseEntity<ErrorRequestResponse>(
                new ErrorRequestResponse(ErrorCode.INTERNAL_SERVER_ERROR.getSubErrorCode(), ex.getMessage(), ResponseStatus.FAILURE.name()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    protected ResponseEntity<ErrorRequestResponse> handleIllegalRequest(final IllegalArgumentException ex) {

        return new ResponseEntity<ErrorRequestResponse>(
                new ErrorRequestResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ResponseStatus.FAILURE.name()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ContraintViolationException.class})
    protected ResponseEntity<ErrorRequestResponse> handleContraintViolationException(final ContraintViolationException ex) {

        return new ResponseEntity<ErrorRequestResponse>(
                new ErrorRequestResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), ResponseStatus.FAILURE.name()), HttpStatus.BAD_REQUEST);
    }
}
