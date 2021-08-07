package com.example.products.services;

import com.example.products.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {
    List<Product> productList = new ArrayList<>();

    public void createProduct(Product product){
       productList.add(product);
    }

    public void readProduct(Product product){

    }

    public void updateProduct(Product product){

    }

    public void deleteProduct(Product product){

    }

    public List<Product> getAll(){
        return productList;
    }
}
