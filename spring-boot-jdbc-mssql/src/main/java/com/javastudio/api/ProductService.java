package com.javastudio.api;

import com.javastudio.dto.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> findAll();

    List<Product> findById(Long id);
}
