package com.service.order.controller;


import com.service.order.entity.Order;
import com.service.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Autowired
    private OrderService service;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Order order) {
        return new ResponseEntity<>(service.placeOrder(order), HttpStatus.ACCEPTED);
    }

}
