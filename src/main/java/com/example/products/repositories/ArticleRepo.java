package com.example.products.repositories;

import com.example.products.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article, Integer> {}
