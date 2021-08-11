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
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String name;
    private String content;
    private Date publicationDate;
}
