package com.example.ilm_back.business;

import com.example.ilm_back.business.dto.CityDto;
import com.example.ilm_back.business.dto.StatisticDto;
import com.example.ilm_back.business.dto.WeatherDataDTO;
import com.example.ilm_back.business.dto.WeatherResponse;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Salvestab ühe linna ilmaandmed andmebaasi.")
    public void saveWeatherData(@RequestParam String city,
                                @RequestParam Double temp,
                                @RequestParam Double wind,
                                @RequestParam Integer humidity) {

        WeatherDataDTO request = WeatherDataDTO.builder()
                .city(city)
                .temp(BigDecimal.valueOf(temp))
                .wind(BigDecimal.valueOf(wind))
                .humidity(humidity)
                .build();

        weatherService.saveWeatherData(request);
    }

    @GetMapping("/show")
    @Operation(summary = "Tagastab linna nime järgi andmebaasi salvestatud ilmainfo.")
    public List<StatisticDto> getWeatherData(@RequestParam String city) {

        return weatherService.getWeatherData(city);
    }

    @GetMapping("/manual/get-weather")
    @Operation(summary = "Tagastab linna nime järgi OpenWeatherMapist ilmaandmed.")
    public WeatherResponse getWeatherDataNew(@RequestParam String city) {
        return weatherService.getWeatherDataNew(city);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Kustutab kogu andmebaasi salvestatud ilmaandmete statistika.")
    public void deleteWeatherData() {
        weatherService.deleteWeatherData();
    }

    @PostMapping("/add")
    @Operation(summary = "Lisab linna nime nimekirja, mille alusel regulaarselt ilmaandmeid kogutakse.")
    public void addCity(@RequestParam String cityName) {
        citiesService.createAndSaveCity(cityName);
    }

    @GetMapping("/get-cities")
    @Operation(summary = "Tagastab nimekirja linnadest, mille kohta regulaarselt ilmaandmeid kogutakse.")
    public List<CityDto> getRecordedCities() {
        return citiesService.getRecordedCities();
    }

    @DeleteMapping("/remove")
    @Operation(summary = "Eemaldab linna nime nimekirjast, mille alusel regulaarselt ilmaandmeid kogutakse.")
    public void removeCity(@RequestParam String cityName) {
        citiesService.removeCity(cityName);
    }
}
