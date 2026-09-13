package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {

}