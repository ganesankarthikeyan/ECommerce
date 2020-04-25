/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.mapper;

import com.ecommerce.pojo.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author karthikg
 */
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int arg1) throws SQLException {
        Product product = new Product();
        product.setProductName(rs.getString("productName"));
        product.setProductPrice(rs.getInt("productPrice"));
        product.setProductQuantity(rs.getInt("productQuantity"));
        return product;
    }

}
