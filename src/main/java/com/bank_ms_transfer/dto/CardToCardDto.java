package com.bank_ms_transfer.dto;

import com.bank_ms_transfer.enums.TransferStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardToCardDto {

    @NotNull(message = "User ID can't be null !")
    private Long userId;

    @NotBlank(message = "Card number can't be null or blank !")
    private String fromCard;

    @NotBlank(message = "Card number can't be null or blank !")
    private String toCard;

    @NotNull(message = "Amount can't be null !")
    private BigDecimal amount;

    @NotBlank(message = "Currency can't be null or blank !")
    private String currency;

    @NotNull(message = "Transfer status can't be null !")
    private TransferStatus transferStatus;

}
