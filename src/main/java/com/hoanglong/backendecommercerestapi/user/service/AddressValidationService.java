package com.hoanglong.backendecommercerestapi.user.service;

import com.hoanglong.backendecommercerestapi.exception.ItemNotFoundException;
import com.hoanglong.backendecommercerestapi.user.enums.CustomerMessage;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.AddressEntityService;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.CustomerEntityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressValidationService {
    private final AddressEntityService addressEntityService;
    public void controlIsAddressExist(Long id){
        boolean isExist = addressEntityService.ExistById(id);
        if(!isExist){
            throw new ItemNotFoundException(CustomerMessage.NOT_FOUND);
        }
    }
}
