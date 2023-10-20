package com.hoanglong.backendecommercerestapi.user.service.entityservice;

import com.hoanglong.backendecommercerestapi.user.entity.Address;
import com.hoanglong.backendecommercerestapi.user.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressEntityService {
    private final AddressRepository addressRepository;
    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }
    public List<Address> findAllByID(List<Long> id){
        return addressRepository.findAllById(id);
    }

    public void SaveAddress(List<Address> addresses){
        addressRepository.saveAll(addresses);
    }

    public Optional<Address> findByID(Long id){
        return addressRepository.findById(id);
    }

    public boolean ExistById(Long id){
        return addressRepository.existsById(id);
    }

}
