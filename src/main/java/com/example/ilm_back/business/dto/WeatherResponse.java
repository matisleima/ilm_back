package com.example.ilm_back.business.dto;

import com.example.ilm_back.domain.statistic.Statistic;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherResponse implements Serializable {
    private Main main;
    @NotNull
    private Wind wind;
    @NotNull
    private String name;
}