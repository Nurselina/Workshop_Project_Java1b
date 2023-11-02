package com.tobeto.spring.b.dataAccess;

import com.tobeto.spring.b.entities.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductsImpl implements ProductsDao {

    private final List<Products> productsList = new ArrayList<>();

    @Override
    public List<Products> getProducts (){
        return productsList;
    }
    @Override
    public void addProduct(Products products){
        productsList.add(products);
    }
    @Override
    public void deleteProduct(int id){
        productsList.removeIf(products -> products.getId()==id);
    }

}
