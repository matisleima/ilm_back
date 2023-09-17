package com.example.ilm_back.business.dto;

import com.example.ilm_back.domain.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String city;
}