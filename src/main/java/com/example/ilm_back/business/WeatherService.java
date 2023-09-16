package com.example.ilm_back.business;

import com.example.ilm_back.domain.statistic.Statistic;
import com.example.ilm_back.domain.statistic.StatisticMapper;
import com.example.ilm_back.domain.statistic.StatisticService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Resource
    private StatisticService statisticService;
    @Resource
    private StatisticMapper statisticMapper;
    public void saveWeatherData(WeatherDataDTO request) {
        Statistic statistic = statisticMapper.toStatistic(request);
        statisticService.saveWeatherData(statistic);

    }
}
