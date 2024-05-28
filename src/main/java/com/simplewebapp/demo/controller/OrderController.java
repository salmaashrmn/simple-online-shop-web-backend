package com.simplewebapp.demo.controller;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.order.OrderReqDto;
import com.simplewebapp.demo.dto.order.OrderUpdateReqDto;
import com.simplewebapp.demo.service.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private OrderCreateService orderCreateService;
    @Autowired
    private OrderUpdateService orderUpdateService;
    @Autowired
    private OrderDeleteService orderDeleteService;
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/list")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> listOrder(){
        return orderListService.list();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> createOrder(@RequestBody OrderReqDto request){
        return orderCreateService.create(request);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> updateOrder(@RequestBody OrderUpdateReqDto request){
        return orderUpdateService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> deleteOrder(@PathVariable Long id){
        return orderDeleteService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> detailOrder(@PathVariable Long id){
        return orderDetailService.detail(id);
    }
}
