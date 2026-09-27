package com.github.felipemartins152.consolidator.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "blacklisted_tokens")
public class BlacklistedToken {

    @Id
    private String jti;

    @Column(nullable = false)
    private Instant expiresAt;

}