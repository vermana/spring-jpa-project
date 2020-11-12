package com.techie.jpa.repository;


import com.techie.jpa.entity.Cart;
import com.techie.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
}
