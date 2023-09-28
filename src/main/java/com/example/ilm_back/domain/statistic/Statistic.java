package com.example.ilm_back.domain.statistic;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "temp", nullable = false)
    private BigDecimal temp;

    @NotNull
    @Column(name = "wind", nullable = false)
    private BigDecimal wind;

    @NotNull
    @Column(name = "humidity", nullable = false)
    private Integer humidity;

    private String time;

}