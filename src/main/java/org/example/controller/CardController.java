package org.example.controller;

import org.example.model.DiscountCard;
import org.example.model.Product;
import org.example.service.serviceInterface.DiscountCardServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final DiscountCardServiceInterface discountCardServiceInterface;

    public CardController(DiscountCardServiceInterface discountCardServiceInterface) {
        this.discountCardServiceInterface = discountCardServiceInterface;
    }

    @GetMapping
    public List<DiscountCard> findAll() {
        return discountCardServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public DiscountCard findCardById(@PathVariable Long id) throws ClassNotFoundException {
        return discountCardServiceInterface.getDiscountCardById(id);
    }

    @PostMapping("/new")
    public HttpStatus createCard(@RequestBody DiscountCard discountCard) {
        discountCardServiceInterface.create(discountCard);
        return HttpStatus.CREATED;
    }

    @PostMapping("/update/{id}")
    public HttpStatus updateCard(@RequestBody DiscountCard discountCard, Long id) throws ClassNotFoundException {
        discountCardServiceInterface.update(discountCard, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCard(@PathVariable long id) throws ClassNotFoundException {
        discountCardServiceInterface.delete(id);
        return HttpStatus.OK;
    }
}
