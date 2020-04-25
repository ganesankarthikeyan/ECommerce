/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.controller;

import com.ecommerce.pojo.Order;
import com.ecommerce.pojo.Product;
import com.ecommerce.pojo.Update;
import com.ecommerce.service.ServiceClass;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karthikg
 */
@RestController
public class JdbcController {

    @Autowired
    ServiceClass service;

    @PostMapping("/save")
    public String save(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/product/{productName}")
    public Product findProduct(@PathVariable String productName) {
        return service.findProduct(productName);
    }

    @PostMapping("/update")
    public String update(@RequestBody Update update) {
        return service.update(update);
    }

    @DeleteMapping("/delete/{productName}")
    public String delete(@PathVariable String productName) {
        return service.delete(productName);
    }

    @GetMapping("/allProducts")
    public List<Map<String, Object>> allProducts() {
        return service.allProducts();
    }

    @PostMapping("/order")
    public String order(@RequestBody Order order) {
        return service.order(order);
    }

    @GetMapping("/allOrders")
    public List<Map<String, Object>> allOrders() {
        return service.allOrders();
    }

}
