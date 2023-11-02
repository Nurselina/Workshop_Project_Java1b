package com.tobeto.spring.b.dataAccess;

import com.tobeto.spring.b.entities.Products;

import java.util.List;

public interface ProductsDao {
    List<Products> getProducts();
    void addProduct (Products products);
    void deleteProduct(int id);
}
