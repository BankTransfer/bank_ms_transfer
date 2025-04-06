package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.AccountToAccountDto;
import com.bank_ms_transfer.dto.AccountToCardDto;
import com.bank_ms_transfer.service.AccountToAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account_to_account")
public class AccountToAccountController {
    private final AccountToAccountService accountToAccountService;

    @GetMapping("/{id}")
    public AccountToAccountDto getAccountToAccount(@PathVariable String id) {
        return accountToAccountService.getAccountToAccountById(id);
    }

    @GetMapping
    public List<AccountToAccountDto> getAll() {
        return accountToAccountService.getAllAccountToAccount();
    }

    @PostMapping
    public void save(@RequestBody AccountToAccountDto accountToAccountDto) {
        accountToAccountService.saveAccountToAccount(accountToAccountDto);
    }

    @DeleteMapping
    public void deleteById(String id) {
        accountToAccountService.deleteAccountToAccountById(id);
    }
}
