package com.example.ilm_back.domain.statistic;

import com.example.ilm_back.business.StatisticDto;
import com.example.ilm_back.business.WeatherDataDTO;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatisticMapper {


    Statistic toStatistic(WeatherDataDTO weatherDataDTO);
}