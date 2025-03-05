package com.bank_ms_transfer.controller;

import com.bank_ms_transfer.dto.TransferDto;
import com.bank_ms_transfer.enums.TransferType;
import com.bank_ms_transfer.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/newTransfer")
    public ResponseEntity<TransferDto> createTransfer(@RequestBody TransferDto transferDto) {
        TransferDto createdTransfer = transferService.createTransfer(transferDto);
        return ResponseEntity.ok(createdTransfer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferDto> getTransferById(@PathVariable Long id) {
        return ResponseEntity.ok(transferService.getTransferById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TransferDto>> getAllTransfers() {
        return ResponseEntity.ok(transferService.getAllTransfers());
    }

    @PostMapping
    public void saveTransfer(@RequestBody TransferDto transferDto) {
        transferService.saveTransfer(transferDto);
    }

    @DeleteMapping
    public void deleteTransferById(Long id) {
        transferService.deleteTransferById(id);
    }
}
