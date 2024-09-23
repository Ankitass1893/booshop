package com.example.bookdemo.repositories;

import com.example.bookdemo.dao.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

