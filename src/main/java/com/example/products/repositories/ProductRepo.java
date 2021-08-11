package com.example.products.repositories;

import com.example.products.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    List<Product> findAllByOrderByIdAsc();
    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByOrderByDescriptionAsc();
    List<Product> findAllByOrderByImplementationCostAsc();
}
