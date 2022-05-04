package mccool.michelle.weather.services;

import mccool.michelle.weather.models.WeatherApiResponse;

import java.util.Optional;

public interface WeatherService {

    Optional<WeatherApiResponse> requestDataFromApi(String lat, String lon);
}

