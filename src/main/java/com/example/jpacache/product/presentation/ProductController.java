package com.example.jpacache.product.presentation;

import com.example.jpacache.product.application.ProductService;
import com.example.jpacache.product.dto.ProductApiResult;
import com.example.jpacache.product.dto.ProductCreateResponse;
import com.example.jpacache.product.dto.ProductForm;
import com.example.jpacache.product.dto.ProductReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductApiResult> create(@RequestBody ProductForm productForm) {
        ProductCreateResponse response = productService.create(productForm);
        log.info("상품 생성 API 호출");
        return new ResponseEntity<>(new ProductApiResult("상품 생성 완료", response), CREATED);
    }

    @PatchMapping("/products/{product-id}")
    public ResponseEntity<ProductApiResult> update(@PathVariable("product-id") Long productId, @RequestBody ProductForm productForm) {
        ProductCreateResponse response = productService.update(productId, productForm);
        log.info("상품 수정 API 호출");
        return ResponseEntity.ok(new ProductApiResult("상품 이름 수정 완료", response));
    }

    @GetMapping("/products")
    public ResponseEntity<ProductApiResult> readAll() {
        List<ProductReadResponse> response = productService.readAll();
        return ResponseEntity.ok(new ProductApiResult("상품 전체 조회 완료", response));
    }

    @GetMapping("/products/{product-id}")
    public ResponseEntity<ProductApiResult> readById(@PathVariable("product-id") Long productId) {
        ProductReadResponse response = productService.readById(productId);
        log.info("상품 id : {} 조회 API 호출", productId);
        return ResponseEntity.ok(new ProductApiResult("상품 아이디로 조회 완료", response));
    }

    @GetMapping("/products/cond")
    public ResponseEntity<ProductApiResult> readByName(@RequestParam String name) {
        ProductReadResponse response = productService.readByName(name);
        log.info("상품 이름 : {} 조회 API 호출", name);
        return ResponseEntity.ok(new ProductApiResult("상품 이름으로 조회 완료", response));
    }
}
