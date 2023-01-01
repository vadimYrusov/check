package org.example.controller;

import org.example.model.Check;
import org.example.model.Product;
import org.example.service.serviceInterface.CheckServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CheckController {

    private final CheckServiceInterface checkServiceInterface;

    public CheckController(CheckServiceInterface checkServiceInterface) {
        this.checkServiceInterface = checkServiceInterface;
    }

    @GetMapping
    public List<Check> findAll() {
        return checkServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public Check findCheckById(@PathVariable Long id) throws ClassNotFoundException {
        return checkServiceInterface.getCheckById(id);
    }

    @PostMapping("/new")
    public HttpStatus createCheck(@RequestBody Check check) {
        checkServiceInterface.create(check);
        return HttpStatus.CREATED;
    }

    @PostMapping("/update/{id}")
    public HttpStatus updateCheck(@RequestBody Check check, Long id) throws ClassNotFoundException {
        checkServiceInterface.update(check, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCheck(@PathVariable long id) throws ClassNotFoundException {
        checkServiceInterface.delete(id);
        return HttpStatus.OK;
    }
}
