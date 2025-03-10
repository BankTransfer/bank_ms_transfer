package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.AccountToCardDto;
import com.bank_ms_transfer.service.AccountToCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account_to_card")
public class AccountToCardController {
    private final AccountToCardService accountToCardService;

    @GetMapping("/{id}")
    public AccountToCardDto getAccountToCard(@PathVariable String id) {
        return accountToCardService.getAccountToCardById(id);
    }

    @GetMapping
    public List<AccountToCardDto> getAll() {
        return accountToCardService.getAllAccountToCard();
    }

    @PostMapping
    public void save(@RequestBody AccountToCardDto accountToCardDto) {
        accountToCardService.saveAccountToCard(accountToCardDto);
    }

    @DeleteMapping
    public void deleteById(String id) {
        accountToCardService.deleteAccountToCardById(id);
    }

}
