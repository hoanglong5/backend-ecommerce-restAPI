package com.hoanglong.backendecommercerestapi.user.controller;

import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressSaveDto;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.service.AddressService;
import com.hoanglong.backendecommercerestapi.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final AddressService addressService;
    @GetMapping("")
    public List<CustomerWithAddressDto> findAllCustomerDto(){
        return customerService.FindAllCustomerDto();
    }
    @GetMapping("/all")
    public List<Customer> findALl(){
        return customerService.FindAllCustomer();
    }

    @GetMapping("/{id}")
    public CustomerWithAddressDto findByID(@PathVariable Long id){
        return customerService.FindCustomerDto(id);
    }
    @DeleteMapping("/{id}")
    public void DeleteCustomer(@PathVariable Long id){
        customerService.DeleteCustomer(id);
    }

    @PostMapping("")
    public void SaveNewCustomer(@RequestBody CustomerWithAddressSaveDto customerWithAddressSaveDto){
        customerService.SaveNewCustomer(customerWithAddressSaveDto);
    }
    @PutMapping("/{id}")
    public void UpdateCustomer(@PathVariable Long id, @RequestBody CustomerWithAddressSaveDto customerWithAddressSaveDto){
        customerService.UpdateCustomer(id,customerWithAddressSaveDto);
    }
}
