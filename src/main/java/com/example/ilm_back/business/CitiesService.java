package com.example.ilm_back.business;

import com.example.ilm_back.business.dto.CityDto;
import com.example.ilm_back.domain.city.City;
import com.example.ilm_back.domain.city.CityMapper;
import com.example.ilm_back.domain.city.CityService;
import com.example.ilm_back.infrastructure.BusinessException;
import com.example.ilm_back.infrastructure.Error;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;
    @Resource
    private CityMapper cityMapper;
    public void createAndSaveCity(String cityName) {
        if (!cityAlreadyExists(cityName)) {
            City city = new City();
            city.setCity(cityName);
            cityService.addCity(city);
        } else {
            throw new BusinessException(Error.CITY_ALREADY_RECORDED.getMessage(), Error.CITY_ALREADY_RECORDED.getErrorCode());
        }
    }

    public boolean cityAlreadyExists(String cityName) {
        return cityService.cityAlreadyExists(cityName);
    }

    public List<CityDto> getRecordedCities() {
        List<City> recordedCities = cityService.getRecordedCities();
        return cityMapper.toDtos(recordedCities);
    }

    public void removeCity(String cityName) {
        City city = cityService.getCityBy(cityName);
        cityService.removeCity(city);
    }
}
