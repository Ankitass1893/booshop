package com.example.bookdemo.services;

import com.example.bookdemo.dao.Customer;
import com.example.bookdemo.exception.ResourceNotFoundException;
import com.example.bookdemo.repositories.CustomerRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;


public class CustomerService {

  CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Customer not found");
        });
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customerDetails) throws ResourceNotFoundException {
        Customer customer = getCustomerById(id);
        // Update fields
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmails(customerDetails.getEmails());
        customer.setFamilyMembers(customerDetails.getFamilyMembers());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) throws ResourceNotFoundException {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
