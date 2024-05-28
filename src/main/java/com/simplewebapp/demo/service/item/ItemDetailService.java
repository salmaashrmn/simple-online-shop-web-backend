package com.simplewebapp.demo.service.item;

import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemDetailService {
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<Item> detail(Long id){
        Optional<Item> item = itemRepository.findById(id);

        if(item.isEmpty() || item==null){
            throw new RuntimeException("Data not found");
        }

        return ResponseEntity.ok(item.get());
    }
}
