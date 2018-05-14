package com.insticore.studApp.service;

import com.insticore.studApp.model.Product;
import com.insticore.studApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Incorrect identifier"));
    }

    public void publishProduct(Product product) {
        productRepository.save(product);
    }
}
