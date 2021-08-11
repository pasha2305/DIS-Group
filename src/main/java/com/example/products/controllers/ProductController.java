package com.example.products.controllers;

import com.example.products.models.Article;
import com.example.products.models.Product;
import com.example.products.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public List<Article> getArticles(@PathVariable("id") int id){
        return productService.getArticleList(id);
    }

    @GetMapping
    public List<Product> getAll(@RequestParam(value = "sort", required = false) String sort){
        if(sort != null){
            return productService.getAll(sort);
        }
        return productService.getAll();
    }

//    @GetMapping
//    public List<Product> getSortAll(@RequestParam String sort){
//        return productService.getAll(sort);
//    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id_product}")
    public Product updateProduct(@RequestBody Product product,
                              @PathVariable("id_product") int idProduct){
        return productService.update(product, idProduct);
    }

    @DeleteMapping("/{id_product}")
    public void deleteProduct(@PathVariable("id_product") int idProduct){

    }
}
