package com.example.ilm_back.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class WeatherController {

    @Resource
    private WeatherService weatherService;

    @PostMapping("/record")
    public void saveWeatherData(@RequestParam String city,
                                @RequestParam Double temp,
                                @RequestParam Double wind,
                                @RequestParam Integer humidity,
                                @RequestParam String time) {

        WeatherDataDTO request = WeatherDataDTO.builder()
                .city(city)
                .temp(BigDecimal.valueOf(temp))
                .wind(BigDecimal.valueOf(wind))
                .humidity(humidity)
                .time(time)
                .build();

        weatherService.saveWeatherData(request);
    }

    @GetMapping("/show")
    public List<StatisticDto> getWeatherData(@RequestParam String city) {
        return weatherService.getWeatherData(city);
    }
}
