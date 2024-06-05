package com.simplewebapp.demo.repository;

import com.simplewebapp.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByIsAvailable(int isAvailable);
}
