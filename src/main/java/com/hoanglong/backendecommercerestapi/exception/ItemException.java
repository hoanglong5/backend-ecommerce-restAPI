package com.hoanglong.backendecommercerestapi.exception;

import com.hoanglong.backendecommercerestapi.exception.genExceptions.BaseErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Getter
@Setter
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ItemException extends RuntimeException {
    private final BaseErrorMessage baseErrorMessage;
}
