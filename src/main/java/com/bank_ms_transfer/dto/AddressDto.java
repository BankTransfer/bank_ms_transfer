package com.bank_ms_transfer.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
