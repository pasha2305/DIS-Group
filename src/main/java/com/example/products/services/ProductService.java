package com.example.products.services;

import com.example.products.exceptions.AlreadyExistsException;
import com.example.products.exceptions.IncorrectSortFieldException;
import com.example.products.exceptions.NotFoundException;
import com.example.products.models.Article;
import com.example.products.models.Product;
import com.example.products.repositories.ProductRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Article> getArticleList(Integer id){
        Product product = getProductByID(id);
        return product.getArticleList();
    }

    public Product getProductByID(Integer id){
        return productRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

    public List<Product> getAll(String sort){
        switch (sort.toLowerCase()){
            case "id":
                return productRepo.findAllByOrderByIdAsc();
            case "name":
                return productRepo.findAllByOrderByNameAsc();
            case "description":
                return productRepo.findAllByOrderByDescriptionAsc();
            case "implementationcost":
                return productRepo.findAllByOrderByImplementationCostAsc();
        }
        throw new IncorrectSortFieldException();
    }

    public Product createProduct(Product product){
        if(productRepo.existsById(product.getId())){
            throw new AlreadyExistsException("This product already exists.");
        }
        productRepo.save(product);
        return product;
    }

    public Product update(Product product, int id){
        if(productRepo.existsById(id)){
            product.setId(id);
            productRepo.save(product);
            return product;
        }else {
            throw new NotFoundException();
        }
    }

    public void delete(int id){
        Product product = getProductByID(id);
        productRepo.delete(product);
    }
}
