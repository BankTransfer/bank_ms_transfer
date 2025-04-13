package com.bank_ms_transfer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressDto {

    @NotBlank(message = "Street must not be blank")
    private String street;

    @NotBlank(message = "City must not be blank")
    private String city;

    @NotBlank(message = "State must not be blank")
    private String state;

    @NotBlank(message = "Country must not be blank")
    private String country;

    @NotBlank(message = "Postal code must not be blank")
    private String postalCode;
}
