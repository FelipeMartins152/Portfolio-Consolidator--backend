package com.github.felipemartins152.consolidator.repository;

import com.github.felipemartins152.consolidator.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}