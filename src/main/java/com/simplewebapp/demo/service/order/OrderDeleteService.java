package com.simplewebapp.demo.service.order;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.entity.Order;
import com.simplewebapp.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDeleteService {
    @Autowired
    private OrderRepository orderRepository;

    public ResponseEntity<ResponseDto<Object>> delete(Long id){
        Optional<Order> order = orderRepository.findById(id);

        if(order.isEmpty() || order==null){
            return ResponseEntity.ok(new ResponseDto<>().builder()
                    .code("404")
                    .message("Data Not Found")
                    .result(null).build());
        }

        orderRepository.delete(order.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("200")
                .message("Order succesfully deleted")
                .result(null).build());
    }
}