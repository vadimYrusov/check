package org.example.service.serviceInterface;

import org.example.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    List<Product> findAll();

    Product getProductById(Long id) throws ClassNotFoundException;

    Product create (Product product);

    Product update(Product product, Long id) throws ClassNotFoundException;

    void delete (Long id) throws ClassNotFoundException;
}
