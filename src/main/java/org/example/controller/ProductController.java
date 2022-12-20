package org.example.controller;

import org.example.model.Product;
import org.example.service.serviceInterface.ProductServiceAbstract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceAbstract productServiceAbstract;

    public ProductController(ProductServiceAbstract productServiceAbstract) {
        this.productServiceAbstract = productServiceAbstract;
    }

    @GetMapping
    public List<Product> findAll() {
        return productServiceAbstract.findAll();
    }

}
