package org.example.service;

import org.example.dto.AddProductRequest;
import org.example.dto.ChangeProductPriceRequest;
import org.example.dto.RestockProductRequest;
import org.example.exception.CategoryNotFoundException;
import org.example.exception.DuplicateProductException;
import org.example.exception.ProductNotFoundException;
import org.example.model.Category;
import org.example.model.Product;
import org.example.repository.CategoryRepository;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Transactional
    public void addProduct(AddProductRequest request) {
        productRepository.findBySku(request.sku())
                .ifPresent(product -> {
                    throw new DuplicateProductException(request.sku());
                });

        if(request.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price must be positive");
        }

        if(request.stock() < 0) {
            throw new IllegalArgumentException("stock must be greater than or equal 0");
        }

        Category foundCategory = categoryRepository.findByName(request.categoryName())
                .orElseThrow(() -> new CategoryNotFoundException(request.categoryName()));

        Product product = new Product();
        product.setSku(request.sku());
        product.setName(request.name());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.addCategory(foundCategory);

        productRepository.save(product);
    }

    @Transactional
    public void restock(RestockProductRequest request) {
        Product found = productRepository.findById(request.productId())
                .orElseThrow(() -> new ProductNotFoundException(request.productId()));

        if(request.quantity() <= 0) {
            throw new IllegalArgumentException("Restock quantity must be positive");
        }

        found.setStock(found.getStock() + request.quantity()); // dirty checking
    }

    @Transactional
    public void changePrice(ChangeProductPriceRequest request) {
        Product found = productRepository.findById(request.productId())
                .orElseThrow(() -> new ProductNotFoundException(request.productId()));

        if(request.newPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("price must be positive");
        }

        found.setPrice(request.newPrice()); // dirty checking
    }
}
