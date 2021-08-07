package com.example.products.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articleId;
    private  int productId;
    private String name;
    private String content;
    private Date publicationDate;
}
