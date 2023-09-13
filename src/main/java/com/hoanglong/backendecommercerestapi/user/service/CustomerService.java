package com.hoanglong.backendecommercerestapi.user.service;

import com.hoanglong.backendecommercerestapi.user.dto.*;
import com.hoanglong.backendecommercerestapi.user.entity.Address;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.entity.CustomerWithAddress;
import com.hoanglong.backendecommercerestapi.user.mapper.AddressMapper;
import com.hoanglong.backendecommercerestapi.user.mapper.CustomerMapper;
import com.hoanglong.backendecommercerestapi.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    public List<Customer> FindAllCustomer(){
        return customerRepository.findAll();
    }
    public List<CustomerWithAddressDto> FindAllCustomerDto() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customer -> {
                    List<Long> addressIDs = customer.getAddresses().stream()
                            .map(Address::getId)
                            .collect(Collectors.toList());
                    List<Address> addresses = addressService.findAllByID(addressIDs);
                    List<AddressDto> addressDtoList = AddressMapper.INSTANCE.ConvertToListAddressDto(addresses);
                    CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
                    return new CustomerWithAddressDto(customerDto, addressDtoList);
                })
                .collect(Collectors.toList());
    }

    public CustomerWithAddressDto FindCustomerDto(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(NullPointerException::new);

        List<AddressDto> addressDtoList = customer.getAddresses()
                .stream()
                .map(AddressMapper.INSTANCE::ConvertToAddressDto)
                .collect(Collectors.toList());

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);
        return new CustomerWithAddressDto(customerDto, addressDtoList);
    }
    @Transactional
    public void DeleteCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(NullPointerException::new);
        customerRepository.delete(customer);
    }

    @Transactional
    public void SaveNewCustomer(CustomerWithAddressSaveDto customerWithAddressSaveDto){
        Customer customerInfo = CustomerMapper.INSTANCE.convertToCustomerFromCustomerSave(customerWithAddressSaveDto.getCustomerSaveDto());
        List<Address> addresses = AddressMapper.INSTANCE.convertToAddressList(customerWithAddressSaveDto.getAddresses());
        customerInfo.setAddresses(addresses);
        customerRepository.save(customerInfo);
    }

    @Transactional
    public void UpdateCustomer(Long id,CustomerWithAddressSaveDto customerWithAddressSaveDto){
        Customer customer = customerRepository.findById(id).orElseThrow(NullPointerException::new);
        Customer customerInfo = CustomerMapper.INSTANCE.convertToCustomerFromCustomerSave(customerWithAddressSaveDto.getCustomerSaveDto());
        List<Address> addresses = AddressMapper.INSTANCE.convertToAddressList(customerWithAddressSaveDto.getAddresses());
        Customer newCustomer = new Customer();
        newCustomer.setId(id);
        newCustomer.setEmailAddress(customerInfo.getEmailAddress());
        newCustomer.setPhoneNumber(customerInfo.getPhoneNumber());
        newCustomer.setDob(customerInfo.getDob());
        newCustomer.setFirstName(customerInfo.getFirstName());
        newCustomer.setLastName(customerInfo.getLastName());
        newCustomer.setPassword(customerInfo.getPassword());
        newCustomer.setGender(customerInfo.isGender());
        newCustomer.setAddresses(addresses);
        customerRepository.delete(customer);
        customerRepository.save(newCustomer);
    }
}
