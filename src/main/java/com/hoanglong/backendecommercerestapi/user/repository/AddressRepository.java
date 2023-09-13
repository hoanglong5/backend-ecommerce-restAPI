package com.hoanglong.backendecommercerestapi.user.repository;

import com.hoanglong.backendecommercerestapi.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
