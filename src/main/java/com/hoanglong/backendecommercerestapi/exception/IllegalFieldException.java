package com.hoanglong.backendecommercerestapi.exception;

import com.hoanglong.backendecommercerestapi.exception.genExceptions.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalFieldException extends ItemException{
    public IllegalFieldException(BaseErrorMessage message){
        super(message);
    }
}
