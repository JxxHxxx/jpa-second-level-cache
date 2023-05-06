package com.example.jpacache.product.application;

import com.example.jpacache.product.domain.Product;
import com.example.jpacache.product.domain.ProductRepository;
import com.example.jpacache.product.dto.ProductCreateResponse;
import com.example.jpacache.product.dto.ProductForm;
import com.example.jpacache.product.dto.ProductReadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Cacheable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductCreateResponse create(ProductForm form) {
        Product product = productRepository.save(new Product(form.name()));

        return new ProductCreateResponse(product.getId(), product.getName());
    }

    @Transactional
    public ProductCreateResponse update(Long productId, ProductForm form) {
        Product product = productRepository.findById(productId).get();

        product.updateName(form.name());

        return new ProductCreateResponse(product.getId(), product.getName());
    }

    public List<ProductReadResponse> readAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> new ProductReadResponse(
                product.getId(),
                product.getName())).toList();
    }

    public ProductReadResponse readById(Long productId) {
        Product product = productRepository.findById(productId).get();

        return new ProductReadResponse(product.getId(), product.getName());
    }

    public ProductReadResponse readByName(String name) {
        Product product = productRepository.findByName(name).get();

        return new ProductReadResponse(product.getId(), product.getName());
    }
}
