package com.paypal.bfs.test.exceptions;

import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException {

    private String message;

    public RecordNotFoundException(final String message){
        super(message);
        this.message=message;
    }
}
