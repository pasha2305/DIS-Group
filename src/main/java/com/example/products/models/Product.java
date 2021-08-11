package com.example.products.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private BigDecimal implementationCost;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "product")
    @JsonIgnore
    private List<Article> articleList;
}
