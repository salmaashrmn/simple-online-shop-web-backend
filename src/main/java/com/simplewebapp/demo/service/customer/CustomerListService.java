package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerListService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> list(){
        List<Customer> customers = customerRepository.findAll();

        if(customers.isEmpty()||customers==null){
            throw new RuntimeException("Data not found");
        }
        return ResponseEntity.ok(customers);
    }

}
