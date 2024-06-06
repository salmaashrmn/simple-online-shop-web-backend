package com.simplewebapp.demo.controller;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.customer.CustomerReqDto;
import com.simplewebapp.demo.dto.customer.CustomerUpdateReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.service.customer.*;
import com.simplewebapp.demo.service.minio.MinioService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
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
    @Autowired
    private MinioService minioService;

    @PostMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Customer>> listCustomer(){
        return customerListService.list();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> createCustomer(@ModelAttribute @RequestBody CustomerReqDto request){
        return customerCreateService.create(request);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> updateCustomer(@RequestBody CustomerUpdateReqDto request){
        return customerUpdateService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> deleteCustomer(@PathVariable Long id){
        return customerDeleteService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Customer> detailCustomer(@PathVariable Long id){
        return customerDetailService.detail(id);
    }

    @GetMapping("/get-object")
    public ResponseEntity<String> getObject(
            @RequestParam String bucketName, @RequestParam String objectName) {
        String objectContent = minioService.getObject(bucketName, objectName);
        if (objectContent != null) {
            return ResponseEntity.ok(objectContent);
        } else {
            return ResponseEntity.status(500).body("Error fetching object from MinIO");
        }
    }
}
