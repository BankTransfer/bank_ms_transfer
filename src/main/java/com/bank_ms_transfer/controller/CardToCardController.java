package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.CardToCardDto;
import com.bank_ms_transfer.service.CardToCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card_to_card")
public class CardToCardController {

    private final CardToCardService cardToCardService;

    @GetMapping("/{id}")
    public CardToCardDto getById(@PathVariable String id) {
        return cardToCardService.getCardToCardById(id);
    }

    @GetMapping
    public List<CardToCardDto> getAll() {
        return cardToCardService.getAllCardToCard();
    }

    @PostMapping
    public void save(@RequestBody CardToCardDto cardToCardDto) {
        cardToCardService.saveCardToCard(cardToCardDto);
    }

    @DeleteMapping
    public void deleteById(String id) {
        cardToCardService.deleteCardToCardById(id);
    }

}
