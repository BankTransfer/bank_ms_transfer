package com.bank_ms_transfer.dto;

import lombok.Data;

@Data
public class CardToCardDto {

    private Long userId;
    private String fromCard;
    private String toCard;

}
