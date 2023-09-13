package com.hoanglong.backendecommercerestapi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerSaveDto {
    private String emailAddress;
    private String phoneNumber;
    private Date dob;
    private String firstName;
    private String lastName;
    private boolean gender;
    private String password;

}
