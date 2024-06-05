package com.simplewebapp.demo.controller;

import com.simplewebapp.demo.dto.ResponseDto;
import com.simplewebapp.demo.dto.item.ItemReqDto;
import com.simplewebapp.demo.dto.item.ItemUpdateReqDto;
import com.simplewebapp.demo.entity.Item;
import com.simplewebapp.demo.service.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
    @Autowired
    private ItemListService itemListService;
    @Autowired
    private ItemCreateService itemCreateService;
    @Autowired
    private ItemUpdateService itemUpdateService;
    @Autowired
    private ItemDeleteService itemDeleteService;
    @Autowired
    private ItemDetailService itemDetailService;

    @PostMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Item>> listItems(){
        return itemListService.list();
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> createItem(@RequestBody ItemReqDto request){
        return itemCreateService.create(request);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> updateItem(@RequestBody ItemUpdateReqDto request){
        return itemUpdateService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<ResponseDto<Object>> deleteItem(@PathVariable Long id){
        return itemDeleteService.delete(id);
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public ResponseEntity<Item> detailItem(@PathVariable Long id){
        return itemDetailService.detail(id);
    }
}
