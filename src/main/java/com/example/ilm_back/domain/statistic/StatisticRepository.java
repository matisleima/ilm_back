package com.example.ilm_back.domain.statistic;

import com.example.ilm_back.domain.statistic.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}