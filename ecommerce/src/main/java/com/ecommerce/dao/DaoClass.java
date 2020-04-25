/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.dao;

import com.ecommerce.mapper.ProductRowMapper;
import com.ecommerce.pojo.Order;
import com.ecommerce.pojo.Product;
import com.ecommerce.pojo.Update;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author karthikg
 */
@Repository
public class DaoClass {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String insertProducts = "insert into products (productName, productQuantity, productPrice) values (?, ?, ?);";

    final String insertOrders = "insert into orders (name, quantity, email) values (?, ?, ?);";

    public void save(Product product) {
        jdbcTemplate.update(insertProducts, product.getProductName(), product.getProductQuantity(), product.getProductPrice());
    }

    public Product findProduct(String productName) {
        try {
            String query = "select * from products where productName = ?";
            Product product = jdbcTemplate.queryForObject(query, new Object[]{productName}, new ProductRowMapper());
            return product;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void update(Update update) {
        String query = "update products set productName = ? where productName = ?;";
        jdbcTemplate.update(query, update.getToName(), update.getFromName());
    }

    public void delete(String productName) {
        String query = "delete from products where productName = ?";
        jdbcTemplate.update(query, productName);
    }

    public List<Map<String, Object>> allProducts() {
        String query = "select * from products";
        return jdbcTemplate.queryForList(query);
    }

    public void updateQuantity(int remaining, String orderName) {
        String update = "update products set productQuantity = ? where productName = ?;";
        jdbcTemplate.update(update, remaining, orderName);
    }

    public void insertOrders(Order order) {
        jdbcTemplate.update(insertOrders, order.getName(), order.quantity, order.getEmail());
    }

    public List<Map<String, Object>> allOrders() {
        String query = "select * from orders";
        return jdbcTemplate.queryForList(query);
    }

}
