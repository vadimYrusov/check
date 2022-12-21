package org.example.controller;

import org.example.service.serviceInterface.DiscountCardServiceInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    private final DiscountCardServiceInterface discountCardServiceInterface;

    public CardController(DiscountCardServiceInterface discountCardServiceInterface) {
        this.discountCardServiceInterface = discountCardServiceInterface;
    }


}
