package com.example.ilm_back.domain.statistic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
    @Query("select s from Statistic s where s.city = ?1 or ?1 = ''")
    List<Statistic> getWeatherDataBy(String city);
}