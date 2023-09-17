package com.example.ilm_back.business;

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

/**
 * DTO for {@link Statistic}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDataDTO implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String city;
    @NotNull
    private BigDecimal temp;
    @NotNull
    private BigDecimal wind;
    @NotNull
    private Integer humidity;
}