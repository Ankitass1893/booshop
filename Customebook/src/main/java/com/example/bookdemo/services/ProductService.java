package com.example.bookdemo.services;

import com.example.bookdemo.dao.Product;
import com.example.bookdemo.exception.ResourceNotFoundException;
import com.example.bookdemo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

  
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Product not found");
        });
    }

    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Long id, Product ProductDetails) throws ResourceNotFoundException {
        Product Product = getProductById(id);
        // Update fields
        Product.setId(ProductDetails.getId());
        Product.setBookPrice(ProductDetails.getBookPrice());
        Product.setBookQuantity(ProductDetails.getBookQuantity());
        Product.setBookTitle(ProductDetails.getBookTitle());
        return productRepository.save(Product);
    }

    public void deleteProduct(Long id) throws ResourceNotFoundException {
        Product Product = getProductById(id);
        productRepository.delete(Product);
    }
}
