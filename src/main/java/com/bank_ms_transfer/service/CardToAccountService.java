package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.CardToAccountDto;
import com.bank_ms_transfer.exception.InvalidAmountException;
import com.bank_ms_transfer.exception.InvalidPanException;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.CardToAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardToAccountService {

    private final CardToAccountRepository cardToAccountRepository;
    private final TransferMapper transferMapper;

    public CardToAccountDto getCardToAccountById(String id) {
        log.info("Get card to account by ID: {}", id);
        return transferMapper
                .toCardToAccountDto(cardToAccountRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Transfer not found with ID: " + id)));
    }

    public List<CardToAccountDto> getAllCardToAccount() {
        log.info("Get all card to account");
        return cardToAccountRepository
                .findAll()
                .stream()
                .map(transferMapper::toCardToAccountDto)
                .collect(Collectors.toList());
    }

    public void saveCardToAccount(CardToAccountDto cardToAccountDto) {
        if(cardToAccountDto.getFromCard().length() != 16) {
            throw new InvalidPanException("Card number must contain 16 symbols !");
        }
        if(cardToAccountDto.getAmount().compareTo(BigDecimal.ZERO) == -1 ||
                cardToAccountDto.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidAmountException("Invalid amount value !");
        }
       cardToAccountRepository.save(transferMapper.toCardToAccountEntity(cardToAccountDto));
    }

    public void deleteCardToAccountById(String id) {
        cardToAccountRepository.deleteById(id);
    }

}
