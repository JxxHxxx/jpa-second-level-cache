package com.example.jpacache.product.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "product")
public class Product {
    @Id @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
