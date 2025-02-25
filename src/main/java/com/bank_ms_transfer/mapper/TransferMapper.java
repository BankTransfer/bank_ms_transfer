package com.bank_ms_transfer.mapper;

import com.bank_ms_transfer.dto.TransferDto;
import com.bank_ms_transfer.entity.TransferEntity;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {

    public TransferDto toDto(TransferEntity entity) {
        TransferDto dto = new TransferDto();
        dto.setId(entity.getId());
        dto.setTransferType(entity.getTransferType());
        dto.setFromUserId(entity.getFromUserId());
        dto.setToUserId(entity.getToUserId());
        dto.setFromAccount(entity.getFromAccount());
        dto.setToAccount(entity.getToAccount());
        dto.setAmount(entity.getAmount());
        dto.setCurrency(entity.getCurrency());
        dto.setTransferStatus(entity.getTransferStatus());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        return dto;
    }

    public TransferEntity toEntity(TransferDto dto) {
        TransferEntity entity = new TransferEntity();
        entity.setTransferType(dto.getTransferType());
        entity.setFromUserId(dto.getFromUserId());
        entity.setToUserId(dto.getToUserId());
        entity.setFromAccount(dto.getFromAccount());
        entity.setToAccount(dto.getToAccount());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setTransferStatus(dto.getTransferStatus());
        return entity;
    }
}
