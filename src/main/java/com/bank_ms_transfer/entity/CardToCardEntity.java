package com.bank_ms_transfer.entity;

import com.bank_ms_transfer.enums.TransferStatus;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_to_card", schema = "ms_transfer")
@NoArgsConstructor
@Data
public class CardToCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromCard;

    @Column(nullable = false)
    private String toCard;

    @Column
    private BigDecimal amount;

    @Column
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TransferStatus transferStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}