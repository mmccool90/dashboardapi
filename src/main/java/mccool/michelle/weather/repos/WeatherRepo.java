package mccool.michelle.weather.repos;

import mccool.michelle.weather.models.WeatherApiResponse;

import java.util.Optional;

public interface WeatherRepo {
    Optional<WeatherApiResponse> findByLatAndLon(String lat, String lon);
}

