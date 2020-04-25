/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author karthikg
 */
@Configuration
public class PostConstructClass {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String createProducts = "create table products(productName varchar(20), productQuantity INTEGER, productPrice INTEGER);";

    private final String createOrders = "create table orders(name varchar(20), quantity INTEGER, email varchar(100));";

    @PostConstruct
    public void reloadProperties() throws InterruptedException {
        createTablesAtServerStart();
    }

    private void createTablesAtServerStart() {
        try {
            System.out.println("into create tables at server start");
            //creating products table
            jdbcTemplate.execute(createProducts);

            //creating orders table
            jdbcTemplate.execute(createOrders);
        } catch (Exception e) {
            System.out.println("Exception at createTablesAtServerStart " + e);
        }
    }
}
