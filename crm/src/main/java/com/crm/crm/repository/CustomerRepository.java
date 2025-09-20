package com.crm.crm.repository;

import com.crm.crm.entity.Customer;
import com.crm.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByType(String type);
    List<Customer> findByIndustry(String industry);
}
