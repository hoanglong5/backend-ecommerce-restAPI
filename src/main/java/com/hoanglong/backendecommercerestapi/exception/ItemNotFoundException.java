package com.hoanglong.backendecommercerestapi.exception;

import com.hoanglong.backendecommercerestapi.exception.genExceptions.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends ItemException {
    public ItemNotFoundException(BaseErrorMessage message){
        super(message);
    }
}
