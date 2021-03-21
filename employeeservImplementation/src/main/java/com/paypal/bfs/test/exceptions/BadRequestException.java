package com.paypal.bfs.test.exceptions;

import com.paypal.bfs.test.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class BadRequestException extends RuntimeException {

    private Integer errorCode;
    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String description;

    public BadRequestException(){
        super();
        this.errorCode = ErrorCode.BAD_REQUEST.getSubErrorCode();
    }

    public BadRequestException(final String message){
        super();
        this.message = message;
        this.errorCode=ErrorCode.BAD_REQUEST.getSubErrorCode();
    }
    public BadRequestException(final Exception ex){
        super(ex);
    }




}
