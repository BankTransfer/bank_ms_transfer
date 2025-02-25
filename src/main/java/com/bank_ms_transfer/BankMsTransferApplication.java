package com.bank_ms_transfer;

import com.bank_ms_transfer.entity.TransferEntity;
import com.bank_ms_transfer.enums.TransferStatus;
import com.bank_ms_transfer.enums.TransferType;
import com.bank_ms_transfer.repository.TransferRepository;
import com.bank_ms_transfer.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BankMsTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankMsTransferApplication.class, args);
	}
}
