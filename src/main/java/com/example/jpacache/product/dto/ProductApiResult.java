package com.example.jpacache.product.dto;

import lombok.Getter;

@Getter
public class ProductApiResult<T> {
    private final String message;
    private final T response;

    public ProductApiResult(String message, T response) {
        this.message = message;
        this.response = response;
    }
}
