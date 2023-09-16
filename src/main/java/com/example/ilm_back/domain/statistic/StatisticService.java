package com.example.ilm_back.domain.statistic;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

    @Resource
    private StatisticRepository statisticRepository;

    public void saveWeatherData(Statistic statistic) {
        statisticRepository.save(statistic);
    }
}
