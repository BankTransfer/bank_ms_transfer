package com.bank_ms_transfer.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "Name must not be blank")
    private String firstName;

    @NotBlank(message = "Name must not be blank")
    private String lastName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be valid")
    private String email;
    private String phone;

    @Valid
    private AddressDto address;
}
