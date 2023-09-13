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
public class AddressDto {
    private String houseNumber;
    private String street;
    private String ward;
    private String district;
    private String city;
}
