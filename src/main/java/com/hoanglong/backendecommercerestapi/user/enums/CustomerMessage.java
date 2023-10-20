package com.hoanglong.backendecommercerestapi.user.enums;

import com.hoanglong.backendecommercerestapi.exception.genExceptions.BaseErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerMessage implements BaseErrorMessage{
    //Message negative
    NOT_FOUND("Not Found!","Please check the id."),
    FIELD_CANNOT_BE_NULL("Field cannot be blank!","Please be sure that all fields are entered."),
    //Message positive
    FIND_ALL_SUCCESSFUL("Customer List","All Customer"),
    FIND_CUSTOMER_SUCCESSFUL("Customer","Customer information"),
    SAVE_SUCCESSFUL("Save Customer","Save customer successful"),
    UPDATE_SUCCESSFUL("Update Customer","Update customer successful");
    private final String message;
    private final String detailMessage;
}
