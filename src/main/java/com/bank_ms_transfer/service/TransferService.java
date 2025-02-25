package com.bank_ms_transfer.service;

import com.bank_ms_transfer.enums.TransferType;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.bank_ms_transfer.dto.TransferDto;
import com.bank_ms_transfer.entity.TransferEntity;
import com.bank_ms_transfer.enums.TransferStatus;
import com.bank_ms_transfer.mapper.TransferMapper;
import com.bank_ms_transfer.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {
    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper;

    public void initData(){
        TransferEntity transferEntity = new TransferEntity();

        transferEntity.setAmount(BigDecimal.valueOf(500d));
        transferEntity.setTransferStatus(TransferStatus.FAILED);
        transferEntity.setTransferType(TransferType.CARD_TO_CARD);
        transferEntity.setCurrency("KZT");
        transferEntity.setFromPan("1111222233334444");
        transferEntity.setToPan("1111111111111111");
        transferEntity.setFromUserId(1L);
        transferEntity.setToUserId(2L);
        transferRepository.save(transferEntity);
    }

    @Transactional
    public TransferDto createTransfer(TransferDto transferDto) {
        log.info("Creating transfer: {}", transferDto);

        if (transferDto.getAmount().doubleValue() < 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        transferDto.setTransferStatus(TransferStatus.PENDING);
        TransferEntity entity = transferMapper.toEntity(transferDto);
        TransferEntity saveEntity = transferRepository.save(entity);

        log.info("Transfer created with ID: {}", saveEntity.getId());
        return transferMapper.toDto(saveEntity);
    }

    public TransferDto getTransferById(Long id) {
        log.info("Get transfer by ID: {}", id);
        return transferMapper
                .toDto(transferRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Transfer not found with ID: " + id)));
    }

    public List<TransferDto> getAllTransfers() {
        initData();

        log.info("Get all transfers");
        return transferRepository
                .findAll()
                .stream()
                .map(transferMapper::toDto)
                .collect(Collectors.toList());
    }
}
