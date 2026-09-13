package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}