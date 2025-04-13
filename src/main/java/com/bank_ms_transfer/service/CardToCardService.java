package com.bank_ms_transfer.service;

import com.bank_ms_transfer.dto.CardToCardDto;
import com.bank_ms_transfer.exception.InvalidAmountException;
import com.bank_ms_transfer.exception.InvalidPanException;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.CardToCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardToCardService {

    private final CardToCardRepository cardToCardRepository;
    private final TransferMapper transferMapper;

    public CardToCardDto getCardToCardById(String id) {
        log.info("Get card to card by ID: {}", id);
        return transferMapper
                .toCardToCardDto(cardToCardRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Transfer not found with ID: " + id)));
    }

    public List<CardToCardDto> getAllCardToCard() {
        log.info("Get all card to card");
        return cardToCardRepository
                .findAll()
                .stream()
                .map(transferMapper::toCardToCardDto)
                .collect(Collectors.toList());
    }

    public void saveCardToCard(CardToCardDto cardToCardDto) {
        if(cardToCardDto.getFromCard().length() != 16
                || cardToCardDto.getToCard().length() != 16) {
            throw new InvalidPanException("Card number must contain 16 symbols !");
        }
        if(cardToCardDto.getAmount().compareTo(BigDecimal.ZERO) == -1 ||
                cardToCardDto.getAmount().compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidAmountException("Invalid amount value !");
        }
        cardToCardRepository.save(transferMapper.toCardToCardEntity(cardToCardDto));
    }

    public void deleteCardToCardById(String id) {
        cardToCardRepository.deleteById(id);
    }

}
