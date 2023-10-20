package com.hoanglong.backendecommercerestapi.user.service;

import com.hoanglong.backendecommercerestapi.exception.IllegalFieldException;
import com.hoanglong.backendecommercerestapi.exception.ItemNotFoundException;
import com.hoanglong.backendecommercerestapi.user.dto.*;
import com.hoanglong.backendecommercerestapi.user.entity.Address;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.enums.CustomerMessage;
import com.hoanglong.backendecommercerestapi.user.mapper.AddressMapper;
import com.hoanglong.backendecommercerestapi.user.mapper.CustomerMapper;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.AddressEntityService;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerEntityService customerEntityService;
    private final AddressEntityService addressEntityService;
    private final CustomerValidationService customerValidationService;
    private final AddressValidationService addressValidationService;
    public List<CustomerWithAddressDto> FindAllCustomerDto() {
        List<Customer> customerList = customerEntityService.FindAllCustomer();
        return customerList.stream()
                .map(customer -> {
                    List<Long> addressIDs = customer.getAddresses().stream()
                            .map(Address::getId)
                            .collect(Collectors.toList());
                    List<Address> addresses = addressEntityService.findAllByID(addressIDs);
                    List<AddressDto> addressDtoList = AddressMapper.INSTANCE.ConvertToListAddressDto(addresses);
                    CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
                    return new CustomerWithAddressDto(customerDto, addressDtoList);
                })
                .collect(Collectors.toList());
    }

    public CustomerWithAddressDto FindCustomerDto(Long id){
        customerValidationService.controlIsCustomerExist(id);
        Customer customer = customerEntityService.FindById(id);
        List<AddressDto> addressDtoList = customer.getAddresses()
                .stream()
                .map(AddressMapper.INSTANCE::ConvertToAddressDto)
                .collect(Collectors.toList());

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return new CustomerWithAddressDto(customerDto, addressDtoList);
    }

    @Transactional
    public void DeleteCustomer(Long id){
        customerValidationService.controlIsCustomerExist(id);
        customerEntityService.DeleteCustomerById(id);
    }

    @Transactional
    public CustomerWithAddressSaveDto SaveNewCustomer(CustomerWithAddressSaveDto customerWithAddressSaveDto){
        Customer customerInfo = CustomerMapper.INSTANCE.convertToCustomerFromCustomerSave(customerWithAddressSaveDto.getCustomerSaveDto());
        List<Address> addresses = AddressMapper.INSTANCE.convertToAddressList(customerWithAddressSaveDto.getAddresses());
        customerInfo.setAddresses(addresses);
        customerEntityService.SaveCustomer(customerInfo);
        return customerWithAddressSaveDto;
    }

        @Transactional
        public CustomerWithAddressSaveDto UpdateCustomer(Long idCustomer,Long idAddress,CustomerWithAddressSaveDto customerWithAddressSaveDto)  {
        customerValidationService.controlIsCustomerExist(idCustomer);
        addressValidationService.controlIsAddressExist(idAddress);
        Customer customer1 = customerEntityService.FindById(idCustomer);
        Address address = addressEntityService.findByID(idAddress).orElseThrow(NullPointerException::new);
        CustomerSaveDto customerSaveDto = customerWithAddressSaveDto.getCustomerSaveDto();

        customer1.setEmailAddress(customerSaveDto.getEmailAddress());
        customer1.setPhoneNumber(customerSaveDto.getPhoneNumber());
        customer1.setDob(customerSaveDto.getDob());
        customer1.setFirstName(customerSaveDto.getFirstName());
        customer1.setLastName(customerSaveDto.getLastName());
        customer1.setPassword(customerSaveDto.getPassword());
        customer1.setGender(customerSaveDto.isGender());
        customerEntityService.SaveCustomer(customer1);
        List<Long> addressIDs = customer1.getAddresses().stream()
                                        .map(Address::getId)
                                        .toList();
        if (addressIDs.contains(idAddress)){
            address.setHouseNumber(customerWithAddressSaveDto.getAddresses().get(0).getHouseNumber());
            address.setStreet(customerWithAddressSaveDto.getAddresses().get(0).getStreet());
            address.setCity(customerWithAddressSaveDto.getAddresses().get(0).getCity());
            address.setWard(customerWithAddressSaveDto.getAddresses().get(0).getWard());
            address.setDistrict(customerWithAddressSaveDto.getAddresses().get(0).getDistrict());
        }else {
            throw new IllegalFieldException(CustomerMessage.NOT_FOUND);
        }
        return  customerWithAddressSaveDto;
        }
}
