package com.example.ilm_back.business;

import com.example.ilm_back.business.dto.StatisticDto;
import com.example.ilm_back.business.dto.WeatherDataDTO;
import com.example.ilm_back.business.dto.WeatherResponse;
import com.example.ilm_back.domain.statistic.Statistic;
import com.example.ilm_back.domain.statistic.StatisticMapper;
import com.example.ilm_back.domain.statistic.StatisticService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


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
    private final WebClient webClient;

    @Value("${weather.api.key}")
    private String apiKey;


    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public WeatherResponse getWeatherDataNew(String city) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/weather")
                        .queryParam("q", city)
                        .queryParam("units", "metric")
                        .queryParam("appid", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
    }

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
