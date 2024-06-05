package com.simplewebapp.demo.service.item;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.item.ItemUpdateReqDto;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemUpdateService {
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<ResponseDto<Object>> update(ItemUpdateReqDto req){
        Optional<Item> item = itemRepository.findById(req.getItemsId());

        if(item.isEmpty() || item==null){
            throw new RuntimeException("Data not found");
        }

        item.get().setItemsName(req.getItemsName());
        item.get().setItemsCode(req.getItemsCode());
        item.get().setStock(req.getStock());
        item.get().setPrice(req.getPrice());

        itemRepository.save(item.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("202")
                .message("Order succesfully updated")
                .result(item.get()).build());
    }
}
