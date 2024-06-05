package com.simplewebapp.demo.dto.customer;

import io.minio.UploadObjectArgs;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CustomerReqDto {
    private String customerName;
    private String customerAddress;
    private String customerCode;
    private String customerPhone;
    private MultipartFile pic;
}
