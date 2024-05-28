package com.simplewebapp.demo.service.order;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.entity.Order;
import com.simplewebapp.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListService {
    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<ResponseDto<Object>> list(){
        List<Order> orders = orderRepository.findAll();

        if(orders.isEmpty() || orders==null){
            return ResponseEntity.ok(new ResponseDto<>().builder()
                    .code("404")
                    .message("Data Not Found")
                    .result(null).build());
        }

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("200")
                .message("Success")
                .result(orders).build());
    }
}
