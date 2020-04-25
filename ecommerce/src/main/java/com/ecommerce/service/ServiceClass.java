/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.service;

import com.ecommerce.dao.DaoClass;
import com.ecommerce.pojo.Order;
import com.ecommerce.pojo.Product;
import com.ecommerce.pojo.Update;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author karthikg
 */
@Service
public class ServiceClass {

    @Autowired
    DaoClass dao;

    public String save(Product product) {
        //need to check the product present in db or not
        if (findProduct(product.getProductName()) == null) {
            dao.save(product);
            return product.getProductName() + " added successfully ";
        } else {
            return product.getProductName() + " is already present, please update if necessary";
        }
    }

    public Product findProduct(String productName) {
        return dao.findProduct(productName);
    }

    public String update(Update update) {
        if (findProduct(update.getFromName()) != null) {
            dao.update(update);
        } else {
            return "product " + update.getFromName() + " not present";
        }
        return "update successfull";
    }

    public String delete(String productName) {
        if (findProduct(productName) != null) {
            dao.delete(productName);
            return productName + " deleted";
        } else {
            return productName + " not present";
        }
    }

    public List<Map<String, Object>> allProducts() {
        return dao.allProducts();

    }

    public String order(Order order) {
        Product product = findProduct(order.getName());
        if (product != null) {
            if (product.getProductQuantity() >= order.getQuantity()) {
                int remaining = product.getProductQuantity() - order.getQuantity();
                if (remaining > 0) {
                    dao.updateQuantity(remaining, order.getName());
                } else {
                    dao.delete(order.name);
                }
                dao.insertOrders(order);
                return "order placed successfully";
            } else {
                return "only " + product.getProductQuantity() + " are present! TRANSACTION FAILED";
            }
        } else {
            return order.getName() + " not present for order";
        }
    }

    public List<Map<String, Object>> allOrders() {
        return dao.allOrders();
    }

}
