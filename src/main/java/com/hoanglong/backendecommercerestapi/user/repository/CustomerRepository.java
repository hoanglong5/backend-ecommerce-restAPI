package com.hoanglong.backendecommercerestapi.user.repository;

import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
