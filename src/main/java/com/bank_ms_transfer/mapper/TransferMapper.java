package com.bank_ms_transfer.mapper;

import com.bank_ms_transfer.dto.AddressDto;
import com.bank_ms_transfer.dto.CardToAccountDto;
import com.bank_ms_transfer.dto.CardToCardDto;
import com.bank_ms_transfer.dto.UserDto;
import com.bank_ms_transfer.entity.AddressEntity;
import com.bank_ms_transfer.entity.CardToAccountEntity;
import com.bank_ms_transfer.entity.CardToCardEntity;
import com.bank_ms_transfer.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransferMapper {

    CardToAccountDto toCardToAccountDto(CardToAccountEntity cardToAccountEntity);

    CardToAccountEntity toCardToAccountEntity(CardToAccountDto cardToAccountDto);

    CardToCardDto toCardToCardDto(CardToCardEntity cardToCardEntity);

    CardToCardEntity toCardToCardEntity(CardToCardDto cardToCardDto);

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

    AddressDto toAddressDto(AddressEntity addressEntity);
    AddressEntity toAddressEntity(AddressDto addressDto);
}
