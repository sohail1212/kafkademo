package com.service.product.serviceProduct;

import com.google.gson.Gson;
import com.service.product.entity.Order;
import com.service.product.entity.Product;
import com.service.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    private String topicName = "topic1";

    private String topicName1 = "topic2";

    public Product add(Product product) {
        Product existingProduct = productRepository.findByName(product.getName());
        if (existingProduct == null) {
            productRepository.save(product);
            kafkaTemplate.send(topicName, product);
            return product;
        } else {
            existingProduct.setQuantityAvailable(existingProduct.getQuantityAvailable() + product.getQuantityAvailable());
            productRepository.save(existingProduct);
            kafkaTemplate.send(topicName, existingProduct);
            return existingProduct;
        }

    }


    @KafkaListener(groupId = "group1", topics = "topic2")
    public Order consume(String msg) {
        System.out.println(msg);
        Order order = new Gson().fromJson(msg, Order.class);
        Product product = productRepository.findByName(order.getName());
        product.setQuantityAvailable(product.getQuantityAvailable() - order.getOrderQty());
        productRepository.save(product);
        return order;
    }


}
