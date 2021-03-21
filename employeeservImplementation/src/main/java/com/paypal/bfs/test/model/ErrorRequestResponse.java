package com.paypal.bfs.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorRequestResponse {

    private Integer statusCode;
    private String statusMessage;
    private String status;

    public ErrorRequestResponse(final Integer statusCode, final String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ErrorRequestResponse(final String status) {
        this.status = status;
    }
}
