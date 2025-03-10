package com.bank_ms_transfer.dto;

import lombok.Data;

@Data
public class AccountToCardDto {
    private Long userId;
    private String fromAccount;
    private String toCard;
}
