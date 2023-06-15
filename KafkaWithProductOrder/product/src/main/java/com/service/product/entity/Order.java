package com.service.product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order {

    private int id;
    private String name;
    private int orderQty;
    private Double totalAmount;
}
