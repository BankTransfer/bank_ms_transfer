package com.bank_ms_transfer.mapper;

import com.bank_ms_transfer.dto.TransferDto;
import com.bank_ms_transfer.entity.TransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransferMapper {

    public TransferDto toTransferDto(TransferEntity entity);

    public TransferEntity toTransferEntity(TransferDto dto);
}
