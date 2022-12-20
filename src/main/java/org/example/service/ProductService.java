package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.serviceInterface.ProductServiceAbstract;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceAbstract {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ClassNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).orElse(null);
        } else {
            throw new ClassNotFoundException("Product with this id not found");
        }
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long id) throws ClassNotFoundException {
        Product existProduct = productRepository.findById(id).orElse(null);
        if (existProduct != null) {
            existProduct.setTitle(product.getTitle());
            existProduct.setPrice(product.getPrice());
            productRepository.save(existProduct);
        } else {
            throw new ClassNotFoundException("Product with this id not found");
        }
        return existProduct;
    }

    @Override
    public void delete(Long id) throws ClassNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ClassNotFoundException("Product with this id not found");
        }
    }
}
