package com.simplewebapp.demo.service.item;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemDeleteService {
    @Autowired
    private ItemRepository itemRepository;

    public ResponseEntity<ResponseDto<Object>> delete(Long id){
        Optional<Item> item = itemRepository.findById(id);

        if(item.isEmpty() || item==null){
            throw new RuntimeException("Data not found");
        }

        item.get().setIsAvailable(1);
        itemRepository.save(item.get());

        return ResponseEntity.ok(new ResponseDto<>().builder()
                .code("200")
                .message("Item succesfully deleted")
                .result(null).build());
    }
}
