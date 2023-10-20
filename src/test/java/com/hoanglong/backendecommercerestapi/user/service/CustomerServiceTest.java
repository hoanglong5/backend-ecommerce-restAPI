package com.hoanglong.backendecommercerestapi.user.service;

import com.hoanglong.backendecommercerestapi.user.dto.AddressDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressSaveDto;
import com.hoanglong.backendecommercerestapi.user.entity.Address;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.entity.CustomerWithAddress;
import com.hoanglong.backendecommercerestapi.user.mapper.AddressMapper;
import com.hoanglong.backendecommercerestapi.user.mapper.CustomerMapper;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.AddressEntityService;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.CustomerEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.event.ListSelectionEvent;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerEntityService customerEntityService;
    @Mock
    private AddressEntityService addressEntityService;
    @Mock
    private CustomerValidationService customerValidationService;
    @Mock
    private AddressValidationService addressValidationService;

    private Customer CreateDummyCustomer(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setDob(new Date(2000,10,05));
        customer.setEmailAddress("hoanglongpk@gmail.com");
        customer.setPhoneNumber("0942994534");
        customer.setFirstName("hoanglong");
        customer.setLastName("cai");
        customer.setPassword("hoanglongne");
        customer.setGender(true);
        List<Address> addresses = CreateDummyListAddress();
        customer.setAddresses(addresses);
        return customer;
    }
    private List<Customer> CreateDummyCustomerList(){
        List<Customer> customers = new ArrayList<>();
        Customer dummmyCustomer = CreateDummyCustomer();
        customers.add(dummmyCustomer);
        return customers;
    }

    private CustomerDto CreateDummyCustomerDto(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setDob(new Date(2000,10,05));
        customerDto.setEmailAddress("hoanglongpk@gmail.com");
        customerDto.setPhoneNumber("0942994534");
        customerDto.setFirstName("hoanglong");
        customerDto.setLastName("cai");
        customerDto.setGender(true);
        return customerDto;
    }
    private List<CustomerDto> CreateDummyListCustomerDto(){
        List<CustomerDto> customerDtos = new ArrayList<>();
        CustomerDto dummyCustomerDto = CreateDummyCustomerDto();
        customerDtos.add(dummyCustomerDto);
        return customerDtos;
    }


    private Address CreateDummyAddress(){
        Address address = new Address();
        address.setId(1L);
        address.setHouseNumber("25");
        address.setStreet("Nguyen Xi");
        address.setWard("27");
        address.setDistrict("Binh Thanh");
        address.setCity("TPHCM");
        return address;
    }
    private List<Address> CreateDummyListAddress(){
        List<Address> addresses = new ArrayList<>();
        Address dummyAddress = CreateDummyAddress();
        addresses.add(dummyAddress);
        return addresses;
    }
    private AddressDto CreateDummyAddressDto(){
        AddressDto addressDto = new AddressDto();
        addressDto.setHouseNumber("25");
        addressDto.setStreet("Nguyen Xi");
        addressDto.setWard("27");
        addressDto.setDistrict("Binh Thanh");
        addressDto.setCity("TPHCM");
        return addressDto;
    }
    private List<AddressDto> CreateDummyListAddressDto(){
        List<AddressDto> addressDtos = new ArrayList<>();
        AddressDto dummyAddressDto =  CreateDummyAddressDto();
        addressDtos.add(dummyAddressDto);
        return addressDtos;
    }
    private CustomerWithAddressDto CreateDummyCustomerWithAddressDto(){
        CustomerDto customerDto = CreateDummyCustomerDto();
        List<AddressDto> addressDto = CreateDummyListAddressDto();
        return new CustomerWithAddressDto(customerDto,addressDto);
    }

    private List<CustomerWithAddressDto> CreateDummyCustomerWithAddressDtoList(){
        List<CustomerWithAddressDto> customerWithAddressDtos = new ArrayList<>();
        CustomerWithAddressDto customerWithAddressDto = CreateDummyCustomerWithAddressDto();
        customerWithAddressDtos.add(customerWithAddressDto);
        return customerWithAddressDtos;
    }

    @Test
     void shouldFindAllCustomer() {

    }
    @Test
    void findCustomerDto() {

    }
    @Test
    void deleteCustomer() {
        Customer customer = CreateDummyCustomer();
        when(customerEntityService.FindById(anyLong())).thenReturn(customer);
        customerService.DeleteCustomer(anyLong());
    }
    @Test
    void saveNewCustomer() {

    }

    @Test
    void updateCustomer() {
    }
}