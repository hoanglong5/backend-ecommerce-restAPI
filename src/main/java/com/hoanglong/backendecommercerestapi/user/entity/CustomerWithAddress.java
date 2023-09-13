package com.hoanglong.backendecommercerestapi.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerWithAddress {
    private Customer customer;
    private List<Address> addresses;
}
