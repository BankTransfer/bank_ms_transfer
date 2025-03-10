package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.AccountToAccountDto;
import com.bank_ms_transfer.dto.AccountToCardDto;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.AccountToAccountRepository;
import com.bank_ms_transfer.repository.AccountToCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountToCardService {
    private final AccountToCardRepository accountToCardRepository;
    private final TransferMapper transferMapper;

    public AccountToCardDto getAccountToCardById(String id) {
        log.info("Get account to account by ID: {}", id);
        return transferMapper
                .toAccountToCardDto(accountToCardRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Transfer not found with ID: " + id)));
    }

    public List<AccountToCardDto> getAllAccountToCard() {
        log.info("Get all card to account");
        return accountToCardRepository
                .findAll()
                .stream()
                .map(transferMapper::toAccountToCardDto)
                .collect(Collectors.toList());
    }

    public void saveAccountToCard(AccountToCardDto accountToCardDto) {
        accountToCardRepository.save(transferMapper.toAccountToCardEntity(accountToCardDto));
    }

    public void deleteAccountToCardById(String id) {
        accountToCardRepository.deleteById(id);
    }
}
