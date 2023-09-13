package com.hoanglong.backendecommercerestapi.user.mapper;

import com.hoanglong.backendecommercerestapi.user.dto.CustomerDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerSaveDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressSaveDto;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.entity.CustomerWithAddress;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    List<CustomerDto> convertToCustomerDtoList(List<Customer> customerList);
    CustomerDto convertToCustomerDto(Customer customer);

    CustomerDto convertToCustomerDtoFindID(Optional<Customer> customer);

    Customer convertToCustomer(CustomerDto customerDto);

    Customer convertToCustomerFromCustomerSave(CustomerSaveDto customerSaveDto);
    List<Customer> convertToCustomerList(List<CustomerDto> customerDtos);
}
