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
@Table(name = "account_to_card", schema = "ms_transfer")
@NoArgsConstructor
@Data
public class AccountToCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_account", nullable = false)
    private String fromAccount;

    @Column(name = "to_card", nullable = false)
    private String toAccount;

    @Column
    private BigDecimal amount;

    @Column
    private char currency;

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
