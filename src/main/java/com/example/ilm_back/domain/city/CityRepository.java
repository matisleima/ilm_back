package com.example.ilm_back.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select (count(c) > 0) from City c where c.city = ?1")
    boolean existsByCityName(String city);
    @Query("select c from City c where c.city = ?1")
    City findBy(String cityName);
}