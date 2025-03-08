package com.bank_ms_transfer.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "card_to_account", schema = "ms_transfer")
@NoArgsConstructor
@Data
public class CardToAccountEntity {

    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(
            name = "custom-id-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "my_sequence"),
                    @Parameter(name = "increment_size", value = "1"),
                    @Parameter(name = "number_format", value = "c2a-%d")
            }
    )
    private String id;

    @Column(nullable = false)
    private String fromCard;

    @Column(nullable = false)
    private String toAccount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
