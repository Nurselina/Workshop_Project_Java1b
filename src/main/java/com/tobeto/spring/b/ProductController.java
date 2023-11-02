package com.tobeto.spring.b;

import com.tobeto.spring.b.business.ProductsBuss;
import com.tobeto.spring.b.entities.Products;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
    private final ProductsBuss productsBuss;

    public ProductController(ProductsBuss productsBuss) {
        this.productsBuss = productsBuss;
        List<Products> allProduct = productsBuss.getProduct();
    }
    @PostConstruct
    public void addProduct (){
        productsBuss.addProduct(new Products(1,"Elma",50));
        productsBuss.addProduct(new Products(2,"Mandalina",40));
    }
    @GetMapping
        public List<Products> getallProduct(){
        return this.productsBuss.getProduct();
    }

    @PostMapping
    public String createProduct (@RequestBody Products products){
        productsBuss.addProduct(products);
        return "Urun oluşturuldu: " + products.getName() + " (ID: " + products.getId() + ")";
    }



    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Products products){
        Products existingProduct = productsBuss.getProductId(id);

        if (existingProduct != null) {
            existingProduct.setName(products.getName());
            existingProduct.setPrice(products.getPrice());
            productsBuss.updateProduct(existingProduct);
            return "Urun güncellendi: ID: " + id + ", Yeni Bilgiler: \nUrun: " + existingProduct.getName() +
                     ", \nFiyat: " + existingProduct.getPrice();
        }else {
            return "Urun bulunamadı. Güncelleme başarısız.";
        }
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productsBuss.deleteProduct(id);
        return "Urun silindi: " + id;
    }
}
