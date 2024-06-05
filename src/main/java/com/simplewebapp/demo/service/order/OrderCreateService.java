package com.simplewebapp.demo.service.order;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.order.OrderReqDto;
import com.simplewebapp.demo.entity.Customer;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.entity.Order;
import com.simplewebapp.demo.repository.CustomerRepository;
import com.simplewebapp.demo.repository.ItemRepository;
import com.simplewebapp.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderCreateService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ResponseEntity<ResponseDto<Object>> create(OrderReqDto request){
        Order newOrder = new Order();
        newOrder.setOrderCode(request.getOrderCode());
        newOrder.setOrderDate(new Date());

        Customer customer = customerRepository.findById(request.getCustomerId()).get();
        newOrder.setCustomer(customer);

        Item item = itemRepository.findById(request.getItemId()).get();
        newOrder.setItem(item);

        newOrder.setQuantity(request.getQuantity());
        newOrder.setTotalPrice(item.getPrice()*request.getQuantity());

        orderRepository.save(newOrder);
        customer.setLastOrderDate(new Date());
        customerRepository.save(customer);

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("202")
                .message("Order succesfully created")
                .result(newOrder).build());
    }
}
