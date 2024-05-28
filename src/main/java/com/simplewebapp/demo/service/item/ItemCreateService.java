package com.simplewebapp.demo.service.item;

import com.simplewebapp.demo.dto.item.ItemReqDto;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemCreateService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ResponseEntity.BodyBuilder create(ItemReqDto request){
        Item newItem = new Item();
        newItem.setItemsName(request.getItemsName());
        newItem.setItemsCode(request.getItemsCode());
        newItem.setStock(request.getStock());
        newItem.setPrice(request.getPrice());
        newItem.setIsAvailable(0);
        newItem.setLastReStock(new Date());

        itemRepository.save(newItem);

        return ResponseEntity.ok();
    }
}
