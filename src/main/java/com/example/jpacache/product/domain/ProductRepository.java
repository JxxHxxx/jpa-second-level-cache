package com.example.jpacache.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

//    @QueryHints(@QueryHint(name = "javax.persistence.cacheStoreMode", value = "REFRESH"))
//    @Query("select p from Product p where p.id =:productId")
//    Optional<Product> findById(Long productId);
}
