package com.simplewebapp.demo.service.order;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.order.OrderRespDto;
import com.simplewebapp.demo.entity.Order;
import com.simplewebapp.demo.repository.OrderRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderReportService {

    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<ResponseDto<Object>> exportReport() throws JRException {
        List<Order> orderList = orderRepository.findAll();
        List<OrderRespDto> result = orderList.stream().map(this::mapToDto).toList();

        String path = "D:\\Downloads";
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:order.jrxml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "system");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\order.pdf");

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("200")
                .message("Report succesfully generated in path: "+path)
                .result(null).build());
    }

    private OrderRespDto mapToDto(Order order){
        OrderRespDto dto = new OrderRespDto();
        dto.setOrderId(order.getOrderId());
        dto.setOrderCode(order.getOrderCode());
        dto.setOrderDate(order.getOrderDate());
        dto.setItemName(order.getItem().getItemsName());
        dto.setCustomerName(order.getCustomer().getCustomerName());
        dto.setQuantity(order.getQuantity());
        dto.setTotalPrice(order.getTotalPrice());

        return dto;
    }
}
