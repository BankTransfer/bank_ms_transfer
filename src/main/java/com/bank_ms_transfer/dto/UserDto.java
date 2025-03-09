package com.bank_ms_transfer.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private AddressDto address;
}
