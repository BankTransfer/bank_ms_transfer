package com.bank_ms_transfer.dto;

import lombok.Data;

@Data
public class CardToAccountDto {

    private Long userId;
    private String fromCard;
    private String toAccount;

}
