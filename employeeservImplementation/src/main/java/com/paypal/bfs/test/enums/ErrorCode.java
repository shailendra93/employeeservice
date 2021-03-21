package com.paypal.bfs.test.enums;

public enum ErrorCode {

    BAD_REQUEST(400,"Incorrect data was sent"),
    RECORD_NOT_FOUND(404,"Employee Records Not found"),
    INTERNAL_SERVER_ERROR(500,"Internal Server Error");

    private Integer subErrorCode;
    private String message;

    ErrorCode(final Integer subErrorCode, final String message){
        this.subErrorCode=subErrorCode;
        this.message=message;
    }

    public static ErrorCode getEnumBySubErrorCode(final Integer subErrorCode){
        for(ErrorCode errorCode: ErrorCode.values()){
            if(errorCode.getSubErrorCode().equals(subErrorCode)){
                return errorCode;
            }
        }
        return null;
    }

    public static ErrorCode getEnumBySubMessage(final String message){
        for(ErrorCode errorCode: ErrorCode.values()){
            if(errorCode.getMessage().equals(message)){
                return errorCode;
            }
        }
        return null;
    }

    public Integer getSubErrorCode(){return subErrorCode;}

    public String getMessage(){return message;}
}
