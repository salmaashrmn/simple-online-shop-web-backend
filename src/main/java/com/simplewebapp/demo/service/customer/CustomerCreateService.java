package com.simplewebapp.demo.service.customer;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.customer.CustomerReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.repository.CustomerRepository;
import com.simplewebapp.demo.service.minio.MinioService;
import io.minio.MinioClient;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerCreateService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MinioService minio;

    @Transactional
    public ResponseEntity<ResponseDto<Object>> create(CustomerReqDto request){
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName(request.getCustomerName());
        newCustomer.setCustomerCode(request.getCustomerCode());
        newCustomer.setCustomerAddress(request.getCustomerAddress());
        newCustomer.setCustomerPhone(request.getCustomerPhone());
        log.info("udah sampe sini");
//        log.info(request.getPic().getContentType());

        if(request.getPic() != null ){
//            log.info(request.getPic().getContentType());
            try {
                minio.uploadFile(request.getPic());
            }catch (Exception e){
                log.error(e.getMessage());
            }
            newCustomer.setPic(request.getPic().getOriginalFilename());

        }
        newCustomer.setIsActive(0);

        customerRepository.save(newCustomer);
        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("202")
                .message("Customer succesfully created")
                .result(newCustomer).build());
    }
}
