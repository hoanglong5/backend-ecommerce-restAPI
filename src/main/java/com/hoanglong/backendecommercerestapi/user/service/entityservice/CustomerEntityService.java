package com.hoanglong.backendecommercerestapi.user.service.entityservice;

import com.hoanglong.backendecommercerestapi.exception.ItemNotFoundException;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.enums.CustomerMessage;
import com.hoanglong.backendecommercerestapi.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {
    private final CustomerRepository customerRepository;
    public boolean ExistById(Long id){
        return customerRepository.existsById(id);
    }
    public List<Customer> FindAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer FindById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(CustomerMessage.NOT_FOUND));
    }

    public void DeleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    public void SaveCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
