package com.example.products.services;

import com.example.products.exceptions.AlreadyExistsException;
import com.example.products.exceptions.IncorrectSortFieldException;
import com.example.products.exceptions.NotFoundException;
import com.example.products.models.Article;
import com.example.products.models.Product;
import com.example.products.repositories.ArticleRepo;
import com.example.products.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepo articleRepo;
    private final ProductRepo productRepo;

    public ArticleService(ArticleRepo articleRepo, ProductRepo productRepo) {
        this.articleRepo = articleRepo;
        this.productRepo = productRepo;
    }

    public List<Article> getAll(){
        return articleRepo.findAll();
    }

    public Article getArticle(int id){
        return articleRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    public Product getProduct(Integer id){
        return articleRepo.findById(id).orElseThrow(NotFoundException::new).getProduct();
    }

    public List<Article> getAll(String sort){
        switch (sort.toLowerCase()){
            case "id":
                return articleRepo.findAllByOrderByIdAsc();
            case "name":
                return articleRepo.findAllByOrderByNameAsc();
            case "content":
                return articleRepo.findAllByOrderByContentAsc();
            case "publicationdate":
                return articleRepo.findAllByOrderByPublicationDateAsc();
        }
        throw new IncorrectSortFieldException();
    }

    public Article createArticle(Article article, int id){
        if(productRepo.existsById(article.getId())){
            throw new AlreadyExistsException("This article already exists.");
        }
        else {
            Product product = productRepo.findById(id).orElseThrow(NotFoundException::new);
            article.setProduct(product);
            articleRepo.save(article);
            return article;
        }
    }

    public Article update(Article article, int idArticle, int idProduct){
        if(articleRepo.existsById(idArticle)){
            article.setId(idArticle);
            Product product = productRepo.findById(idProduct).orElseThrow(NotFoundException::new);
            article.setProduct(product);
            return article;
        } else {
            throw new NotFoundException();
        }
    }

    public void delete(int id){
        Article article  = getArticle(id);
        articleRepo.delete(article);
    }
}
