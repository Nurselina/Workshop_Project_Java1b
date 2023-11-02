package com.tobeto.spring.b.business;

import com.tobeto.spring.b.entities.Products;
import com.tobeto.spring.b.entities.User;

import java.util.List;

public interface ProductsBuss {
    List<Products> getProduct();
    void addProduct(Products products);
    void deleteProduct(int id);
    Products getProductId(int id);
    void updateProduct(Products products);

}
