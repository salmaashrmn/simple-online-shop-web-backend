package com.simplewebapp.demo.service.order;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.order.OrderReqDto;
import com.simplewebapp.demo.dto.order.OrderUpdateReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.entity.Order;
import com.simplewebapp.demo.repository.CustomerRepository;
import com.simplewebapp.demo.repository.ItemRepository;
import com.simplewebapp.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderUpdateService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<ResponseDto<Object>> update(OrderUpdateReqDto request){
        Optional<Order> order = orderRepository.findById(request.getOrderId());

        if(order.isEmpty() || order==null){
            return ResponseEntity.ok(new ResponseDto<>().builder()
                    .code("404")
                    .message("Data Not Found")
                    .result(null).build());
        }

        order.get().setOrderCode(request.getOrderCode());

        Customer customer = customerRepository.findById(request.getCustomerId()).get();
        order.get().setCustomer(customer);

        Item item = itemRepository.findById(request.getItemId()).get();
        order.get().setItem(item);

        order.get().setQuantity(request.getQuantity());
        order.get().setTotalPrice(item.getPrice()*request.getQuantity());

        orderRepository.save(order.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("202")
                .message("Order succesfully updated")
                .result(order.get()).build());
    }
}
