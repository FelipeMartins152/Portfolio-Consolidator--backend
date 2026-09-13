package com.github.felipemartins152.consolidator.domain;

import com.github.felipemartins152.consolidator.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long transactionId;

    @Enumerated(STRING)
    private TransactionType type;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private LocalDate transactionDate;

    private boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

}