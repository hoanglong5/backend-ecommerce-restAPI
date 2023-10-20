package com.hoanglong.backendecommercerestapi.exception.genExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ExceptionResponse {
    private Date errorDate;
    private String message;
    private String detail;
}
