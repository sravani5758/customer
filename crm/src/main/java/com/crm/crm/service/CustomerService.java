package com.crm.crm.service;


import com.crm.crm.entity.Customer;
import com.crm.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        customer.setName(customerDetails.getName());
        customer.setType(customerDetails.getType());
        customer.setIndustry(customerDetails.getIndustry());
        customer.setGeography(customerDetails.getGeography());
        customer.setSize(customerDetails.getSize());
        customer.setContactInfo(customerDetails.getContactInfo());
        customer.setGstNumber(customerDetails.getGstNumber());
        customer.setAddress(customerDetails.getAddress());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        customerRepository.delete(customer);
    }
}