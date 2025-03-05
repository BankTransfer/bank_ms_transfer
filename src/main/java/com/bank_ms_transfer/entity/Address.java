package com.bank_ms_transfer.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address", schema = "ms_transfer")
@NoArgsConstructor
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
