package com.techie.jpa.controller;


import com.techie.jpa.dto.OrderRequest;
import com.techie.jpa.dto.OrderResponse;
import com.techie.jpa.entity.Customer;
import com.techie.jpa.repository.CustomerRepository;
import com.techie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
    return customerRepository.save(request.getCustomer());
    }


    @GetMapping("/getAllOrders")
    public List<Customer> getAllOrders(){
        return customerRepository.findAll();
    }


    @GetMapping("/getOrdersInfo")
    public List<OrderResponse> getOrderInfo(){

        return customerRepository.productInformation();

    }














}
