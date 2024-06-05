package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.customer.CustomerUpdateReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUpdateService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<ResponseDto<Object>> update(CustomerUpdateReqDto request){
        Optional<Customer> customer = customerRepository.findById(request.getId());

        if(customer.isEmpty() || customer == null){
            throw new RuntimeException("Data not found");
        }

        customer.get().setCustomerId(request.getId());
        customer.get().setCustomerName(request.getCustomerName());
        customer.get().setCustomerAddress(request.getCustomerAddress());
        customer.get().setCustomerCode(request.getCustomerCode());
        customer.get().setCustomerPhone(request.getCustomerPhone());
        customer.get().setPic(request.getPic());

        customerRepository.save(customer.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("202")
                .message("Customer succesfully updated")
                .result(customer.get()).build());
    }
}
