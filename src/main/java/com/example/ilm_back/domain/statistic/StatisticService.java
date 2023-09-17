package com.example.ilm_back.domain.statistic;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    @Resource
    private StatisticRepository statisticRepository;

    public void saveWeatherData(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    public List<Statistic> getWeatherData(String city) {
        return statisticRepository.getWeatherDataBy(city);
    }

    public void deleteWeatherData() {
        statisticRepository.deleteAll();
    }
}
