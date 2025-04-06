package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.AccountToAccountDto;
import com.bank_ms_transfer.dto.CardToAccountDto;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.AccountToAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountToAccountService {
    private final AccountToAccountRepository accountToAccountRepository;
    private final TransferMapper transferMapper;

    public AccountToAccountDto getAccountToAccountById(String id) {
        log.info("Get account to account by ID: {}", id);
        return transferMapper
                .toAccountToAccountDto(accountToAccountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Transfer not found with ID: " + id)));
    }

    public List<AccountToAccountDto> getAllAccountToAccount() {
        log.info("Get all card to account");
        return accountToAccountRepository
                .findAll()
                .stream()
                .map(transferMapper::toAccountToAccountDto)
                .collect(Collectors.toList());
    }

    public void saveAccountToAccount(AccountToAccountDto accountToAccountDto) {
        accountToAccountRepository.save(transferMapper.toAccountToAccountEntity(accountToAccountDto));
    }

    public void deleteAccountToAccountById(String id) {
        accountToAccountRepository.deleteById(id);
    }
}