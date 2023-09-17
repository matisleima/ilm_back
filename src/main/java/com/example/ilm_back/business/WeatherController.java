package com.example.ilm_back.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class WeatherController {

    @Resource
    private WeatherService weatherService;

    @Resource
    private CitiesService citiesService;

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

    @DeleteMapping("/delete")
    public void deleteWeatherData() {
        weatherService.deleteWeatherData();
    }

    @PostMapping("/add")
    public void addCity(@RequestParam String cityName) {
        citiesService.createAndSaveCity(cityName);
    }

    @GetMapping("/get-cities")
    public List<CityDto> getRecordedCities() {
        return citiesService.getRecordedCities();
    }

    @DeleteMapping("/remove")
    public void removeCity(@RequestParam String cityName) {
        citiesService.removeCity(cityName);
    }
}
