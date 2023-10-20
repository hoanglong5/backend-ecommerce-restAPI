package com.hoanglong.backendecommercerestapi.user.service;

import com.hoanglong.backendecommercerestapi.exception.IllegalFieldException;
import com.hoanglong.backendecommercerestapi.exception.ItemNotFoundException;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressSaveDto;
import com.hoanglong.backendecommercerestapi.user.enums.CustomerMessage;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerValidationService {
    private final CustomerEntityService customerEntityService;

    public void controlIsCustomerExist(Long id){
        boolean isExist = customerEntityService.ExistById(id);
        if (!isExist){
            throw new ItemNotFoundException(CustomerMessage.NOT_FOUND);
        }
    }


}
