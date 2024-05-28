package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.dto.customer.CustomerReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreateService {
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public ResponseEntity.BodyBuilder create(CustomerReqDto request){
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(request.getCustomerName());
        newCustomer.setCustomerCode(request.getCustomerCode());
        newCustomer.setCustomerAddress(request.getCustomerAddress());
        newCustomer.setCustomerPhone(request.getCustomerPhone());
        newCustomer.setPic(request.getPic());
        newCustomer.setIsActive(0);

        customerRepository.save(newCustomer);
        return ResponseEntity.ok();
    }
}
