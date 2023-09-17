package com.example.ilm_back.domain.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Resource
    private CityRepository cityRepository;
    public void addCity(City city) {
        cityRepository.save(city);
    }

    public List<City> getRecordedCities() {
        return cityRepository.findAll();
    }

    public void removeCity(City city) {
        cityRepository.delete(city);
    }

    public City getCityBy(String cityName) {
        return cityRepository.findBy(cityName);
    }

    public boolean cityAlreadyExists(String cityName) {
        return cityRepository.existsByCityName(cityName);
    }
}
