package com.example.ilm_back.business;

import com.example.ilm_back.domain.statistic.Statistic;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * DTO for {@link Statistic}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticDto implements Serializable {
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
    @NotNull
    private LocalTime time;
    @NotNull
    private Boolean tracked = false;
}