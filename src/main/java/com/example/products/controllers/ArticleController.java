package com.example.products.controllers;

import com.example.products.models.Article;
import com.example.products.models.Product;
import com.example.products.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<Article> getAll(@RequestParam(value = "sort", required = false) String sort){
        if(sort != null){
            return articleService.getAll(sort);
        }
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductFromArticle(@PathVariable("id") int id){
        return articleService.getProduct(id);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article,
                              @RequestParam Integer idProduct){
        return articleService.createArticle(article, idProduct);
    }

    @PutMapping("/{id_article}")
    public Article updateArticle(@RequestBody Article article,
                              @PathVariable("id_article") Integer id_article,
                              @RequestParam Integer id_product){
        return articleService.update(article, id_article, id_product);
    }

    @DeleteMapping
    public void deleteArticle(@RequestParam int id){
        articleService.delete(id);
    }
}
