package com.javastudio.service;

import com.javastudio.api.ProductService;
import com.javastudio.api.exceptions.NoDataFoundException;
import com.javastudio.dto.Product;
import com.javastudio.mapper.ProductMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product getProductById(Long id) {
        try {
            return jdbcTemplate.queryForObject("select * from Product where id = ?", new Object[]{id}, new ProductMapper());
        } catch (EmptyResultDataAccessException e) {
            logger.warn("No data found for product id: {}", id);
            throw new NoDataFoundException("Product not exists for given id: " + id);
        }
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from Product", new ProductMapper());
    }

    @Override
    public List<Product> findById(Long id) {
        logger.info("=====> id: {}", id);
        return jdbcTemplate.query("select * from product where id = ?", new Object[]{1}, new ProductMapper());
    }
}
