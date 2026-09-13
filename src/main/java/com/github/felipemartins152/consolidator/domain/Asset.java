package com.github.felipemartins152.consolidator.domain;

import com.github.felipemartins152.consolidator.domain.enums.AssetType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long assetId;

    private String name;

    @Enumerated(STRING)
    private AssetType type;

    private BigDecimal currentPrice;

    private String ticker;

    private boolean isActive;

    @OneToMany(mappedBy = "asset")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "asset")
    private List<PriceHistory> priceHistories;

}