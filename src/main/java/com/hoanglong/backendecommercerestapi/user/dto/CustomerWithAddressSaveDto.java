package com.hoanglong.backendecommercerestapi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerWithAddressSaveDto {
    private CustomerSaveDto customerSaveDto;
    private List<AddressDto> addresses ;
}
