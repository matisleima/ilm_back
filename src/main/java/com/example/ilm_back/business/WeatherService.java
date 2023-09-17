package com.example.ilm_back.business;

import com.example.ilm_back.domain.statistic.Statistic;
import com.example.ilm_back.domain.statistic.StatisticMapper;
import com.example.ilm_back.domain.statistic.StatisticService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WeatherService {
    @Resource
    private StatisticService statisticService;
    @Resource
    private StatisticMapper statisticMapper;
    public void saveWeatherData(WeatherDataDTO request) {
        Statistic statistic = statisticMapper.toStatistic(request);
        setTimestampToStatistic(statistic);
        statisticService.saveWeatherData(statistic);
    }

    private static void setTimestampToStatistic(Statistic statistic) {
        Instant now = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy");
        String formattedTimestamp = ldt.format(formatter);
        statistic.setTime(formattedTimestamp);
    }

    public List<StatisticDto> getWeatherData(String city) {
        List<Statistic> weatherData = statisticService.getWeatherData(city);
        return statisticMapper.toDtos(weatherData);
    }

    public void deleteWeatherData() {
        statisticService.deleteWeatherData();
    }
}
