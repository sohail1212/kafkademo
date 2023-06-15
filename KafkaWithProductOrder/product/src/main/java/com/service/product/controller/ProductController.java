package com.service.product.controller;

import com.service.product.entity.Product;
import com.service.product.serviceProduct.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.OK)
    public Product add(@RequestBody Product product){
        return service.add(product);
    }




}
