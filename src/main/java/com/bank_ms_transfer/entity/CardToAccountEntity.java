package com.bank_ms_transfer.entity;

import com.bank_ms_transfer.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "card_to_account", schema = "ms_transfer")
@NoArgsConstructor
@Data
public class CardToAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromCard;

    @Column(nullable = false)
    private String toAccount;

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
