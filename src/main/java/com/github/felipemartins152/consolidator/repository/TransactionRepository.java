package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}