package com.example.ilm_back.domain.statistic;

import com.example.ilm_back.business.StatisticDto;
import com.example.ilm_back.business.WeatherDataDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatisticMapper {


    Statistic toStatistic(WeatherDataDTO weatherDataDTO);

    StatisticDto toDto(Statistic statistic);

    List<StatisticDto> toDtos(List<Statistic> weatherData);
}