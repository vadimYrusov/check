package org.example.controller;

import org.example.model.Product;
import org.example.service.serviceInterface.ProductServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceInterface productServiceInterface;

    public ProductController(ProductServiceInterface productServiceAbstract) {
        this.productServiceInterface = productServiceAbstract;
    }

    @GetMapping
    public List<Product> findAll() {
        return productServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Long id) throws ClassNotFoundException {
        return productServiceInterface.getProductById(id);
    }

    @PostMapping("/new")
    public HttpStatus createProduct(@RequestBody Product product) {
        productServiceInterface.create(product);
        return HttpStatus.CREATED;
    }

    @PostMapping("/update/{id}")
    public HttpStatus updateProduct(@RequestBody Product product, Long id) throws ClassNotFoundException {
        productServiceInterface.update(product, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) throws ClassNotFoundException {
        productServiceInterface.delete(id);
        return HttpStatus.OK;
    }

}
