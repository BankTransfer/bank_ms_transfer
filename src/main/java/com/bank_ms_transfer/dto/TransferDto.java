package com.bank_ms_transfer.dto;

import com.bank_ms_transfer.enums.TransferStatus;
import com.bank_ms_transfer.enums.TransferType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransferDto {
    private Long id;
    private TransferType transferType;
    private TransferStatus transferStatus;

    private Long fromUserId;
    private Long toUserId;
    private String fromAccount;
    private String toAccount;

    private BigDecimal amount;
    private String currency;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
