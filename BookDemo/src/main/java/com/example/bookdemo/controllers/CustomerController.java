package com.example.bookdemo.controllers;

import com.example.bookdemo.dao.Customer;
import com.example.bookdemo.exception.ResourceNotFoundException;
import com.example.bookdemo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) throws ResourceNotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Customer not found");
        });
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws ResourceNotFoundException {
        Customer customer1 = getCustomerById(id);
       
        // Update fields
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setEmails(customer.getEmails());
        customer1.setFamilyMembers(customer.getFamilyMembers());
        return customerRepository.save(customer1);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws ResourceNotFoundException {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
