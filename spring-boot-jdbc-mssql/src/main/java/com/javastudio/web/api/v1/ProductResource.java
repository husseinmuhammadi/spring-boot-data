package com.javastudio.web.api.v1;

import com.javastudio.api.ProductService;
import com.javastudio.api.exceptions.NoDataFoundException;
import com.javastudio.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductResource {

    private final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        try {
            logger.info("id: {}", id);
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (NoDataFoundException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/f/{id}")
    public ResponseEntity<List<Product>> findAll(@PathVariable("id") Long id) {
        logger.info("---> id {}", id);
        return ResponseEntity.ok(productService.findById(id));
    }
}
