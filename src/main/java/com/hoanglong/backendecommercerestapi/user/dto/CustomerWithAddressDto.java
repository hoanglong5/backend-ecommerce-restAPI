package com.hoanglong.backendecommercerestapi.user.dto;

import com.hoanglong.backendecommercerestapi.user.entity.Address;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class CustomerWithAddressDto {
    private CustomerDto customer;
    private List<AddressDto> addresses ;
}
