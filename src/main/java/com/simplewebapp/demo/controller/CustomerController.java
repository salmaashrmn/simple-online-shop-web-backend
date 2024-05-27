package com.simplewebapp.demo.controller;

import com.simplewebapp.demo.dto.customer.CustomerReqDto;
import com.simplewebapp.demo.dto.customer.CustomerUpdateReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.service.customer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerListService customerListService;
    @Autowired
    private CustomerCreateService customerCreateService;
    @Autowired
    private CustomerUpdateService customerUpdateService;
    @Autowired
    private CustomerDeleteService customerDeleteService;
    @Autowired
    private CustomerDetailService customerDetailService;

    @PostMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Customer>> listCustomer(){
        return customerListService.list();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity.BodyBuilder createCustomer(CustomerReqDto request){
        return customerCreateService.create(request);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity.BodyBuilder updateCustomer(CustomerUpdateReqDto request){
        return customerUpdateService.update(request);
    }

    @DeleteMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity.BodyBuilder deleteCustomer(@PathVariable Long id){
        return customerDeleteService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Customer> detailCustomer(@PathVariable Long id){
        return customerDetailService.detail(id);
    }
}
