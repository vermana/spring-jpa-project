package com.techie.jpa.repository;

import com.techie.jpa.dto.OrderResponse;
import com.techie.jpa.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("SELECT new com.techie.jpa.dto.OrderResponse(c.name,p.productName) FROM Customer c JOIN c.productList p")
    public List<OrderResponse> productInformation();


}
