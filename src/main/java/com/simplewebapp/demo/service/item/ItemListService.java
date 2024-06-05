package com.simplewebapp.demo.service.item;

import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemListService {
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<List<Item>> list(){
        List<Item> items = itemRepository.findByIsAvailable(0);

        if(items.isEmpty() || items==null){
            throw new RuntimeException("Data not found");
        }

        return ResponseEntity.ok(items);
    }
}
