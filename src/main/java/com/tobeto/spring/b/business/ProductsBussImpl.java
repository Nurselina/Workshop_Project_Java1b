package com.tobeto.spring.b.business;

import com.tobeto.spring.b.dataAccess.ProductsDao;
import com.tobeto.spring.b.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Servisle ilgili işlemler, veri manipülasyonu, iş mantığı burada gerçekleştirilir.
public class ProductsBussImpl implements ProductsBuss {
    private final ProductsDao productsDao;
    @Autowired
    public ProductsBussImpl(ProductsDao productsDao){
        this.productsDao = productsDao;
    }


    @Override
    public List<Products> getProduct() {

        return productsDao.getProducts();
    }

    @Override
    public void addProduct (Products products) {
        productsDao.addProduct(products);

    }

    @Override
    public void deleteProduct(int id) {
    productsDao.deleteProduct(id);
    }

    @Override
    public Products getProductId(int id) {
        List<Products> productsList = productsDao.getProducts();
        for (Products product1: productsList) {
            if (product1.getId() == id) {
                return product1;
            }

        }
        return null;
    }

    @Override
    public void updateProduct(Products products) {
        List<Products> productsList = productsDao.getProducts();
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId()== products.getId()){
                productsList.set(i,products);
                break;
            }
        }
    }
}
