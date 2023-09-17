package com.example.ilm_back.domain.city;

import com.example.ilm_back.business.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {

    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> recordedCities);
}