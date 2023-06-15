package com.service.order.service;

import com.google.gson.Gson;
import com.service.order.entity.Order;
import com.service.order.entity.Product;
import com.service.order.repository.OrderRepository;
import com.service.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private String TOPIC_NAME = "topic1";

    private String TOPIC_NAME1 = "topic2";

//    public Order add(Order order) {
//        kafkaTemplate.send(TOPIC_NAME1, order);
//        return repo.save(order);
//    }


    @KafkaListener(topics = "topic1", groupId = "group3")
    public Product consume(String msg) {
        System.out.println(msg);
        Product treeObj = new Gson().fromJson(msg, Product.class);
        productRepo.save(treeObj);
        return treeObj;
    }

    public String placeOrder(Order order) {

        Product product = productRepo.findByName(order.getName());
        if (product != null) {
            int quantity = product.getQuantityAvailable() - order.getOrderQty();//10-5=5-6=-1
            if (quantity >= 0) {
                product.setQuantityAvailable(quantity); //5
                productRepo.save(product);
                kafkaTemplate.send(TOPIC_NAME1, order);
                repo.save(order);
                return "Order Placed Successfully ...!";

            }

        }
        return "Order Not Placed...!";
    }

}
