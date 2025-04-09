package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.CardToAccountDto;
import com.bank_ms_transfer.service.CardToAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ ")
public class CardToAccountController {

    private final CardToAccountService cardToAccountService;

    @GetMapping("/{id}")
    public CardToAccountDto getById(@PathVariable String id) {
        return cardToAccountService.getCardToAccountById(id);
    }

    @GetMapping
    public List<CardToAccountDto> getAll() {
        return cardToAccountService.getAllCardToAccount();
    }

    @PostMapping
    public void save(@Valid @RequestBody CardToAccountDto cardToAccountDto) {
        cardToAccountService.saveCardToAccount(cardToAccountDto);
    }

    @DeleteMapping
    public void deleteById(String id) {
        cardToAccountService.deleteCardToAccountById(id);
    }

}
