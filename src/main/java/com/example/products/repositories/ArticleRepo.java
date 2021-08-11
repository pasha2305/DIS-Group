package com.example.products.repositories;

import com.example.products.models.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepo extends CrudRepository<Article, Integer> {
    List<Article> findAll();
    List<Article> findAllByOrderByIdAsc();
    List<Article> findAllByOrderByNameAsc();
    List<Article> findAllByOrderByContentAsc();
    List<Article> findAllByOrderByPublicationDateAsc();
}
