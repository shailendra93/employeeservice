package com.paypal.bfs.test.exceptions;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    public ApplicationException(final String str){
        super(str);
    }

    public ApplicationException(final Throwable ex){
        super(ex);
    }
}
