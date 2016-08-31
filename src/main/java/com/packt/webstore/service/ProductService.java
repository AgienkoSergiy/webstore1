package com.packt.webstore.service;

import com.packt.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getProductByCategory(String category);
    Set<Product> getProductsByFilter(Map<String,
            List<String>> filterParams);
    Product getProductById(String productId);
}
