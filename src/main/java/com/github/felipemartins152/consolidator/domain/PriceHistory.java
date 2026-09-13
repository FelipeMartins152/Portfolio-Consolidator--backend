package com.github.felipemartins152.consolidator.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "price_histories")
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long historyId;

    private BigDecimal closingPrice;

    private LocalDate quoteDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

}