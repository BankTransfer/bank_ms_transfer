package com.bank_ms_transfer.mapper;

import com.bank_ms_transfer.dto.*;
import com.bank_ms_transfer.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransferMapper {

    @Mapping(target = "userId", source = "cardToAccountEntity.userEntity.id")
    CardToAccountDto toCardToAccountDto(CardToAccountEntity cardToAccountEntity);

    @Mapping(target = "userEntity.id", source = "userId")
    CardToAccountEntity toCardToAccountEntity(CardToAccountDto cardToAccountDto);

    @Mapping(target = "userId", source = "cardToCardEntity.userEntity.id")
    CardToCardDto toCardToCardDto(CardToCardEntity cardToCardEntity);

    @Mapping(target = "userEntity.id", source = "userId")
    CardToCardEntity toCardToCardEntity(CardToCardDto cardToCardDto);

    AccountToAccountDto toAccountToAccountDto(AccountToAccountEntity accountToAccountEntity);

    AccountToAccountEntity toAccountToAccountEntity(AccountToAccountDto accountToAccountDto);

    AccountToCardDto toAccountToCardDto(AccountToCardEntity accountToCardEntity);

    AccountToCardEntity toAccountToCardEntity(AccountToCardDto accountToCardDto);

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

    AddressDto toAddressDto(AddressEntity addressEntity);

    AddressEntity toAddressEntity(AddressDto addressDto);
}
