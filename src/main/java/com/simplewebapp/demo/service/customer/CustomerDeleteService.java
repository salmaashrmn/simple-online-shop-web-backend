package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDeleteService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<ResponseDto<Object>> delete(Long id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isEmpty() || customer == null){
            throw new RuntimeException("Data not found");
        }

        customer.get().setIsActive(1);
        customerRepository.save(customer.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("200")
                .message("Order succesfully deleted")
                .result(null).build());
    }
}
