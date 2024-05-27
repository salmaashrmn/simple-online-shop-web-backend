package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Customer> detail(Long id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty() || customer == null){
            throw new RuntimeException("Data not found");
        }

        return ResponseEntity.ok(customer.get());
    }
}
