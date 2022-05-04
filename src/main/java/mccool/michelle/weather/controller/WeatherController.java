package mccool.michelle.weather.controller;

import mccool.michelle.weather.models.WeatherApiResponse;
import mccool.michelle.weather.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("weather")
public class WeatherController {
    private static Logger logger = LoggerFactory.getLogger(WeatherController.class);
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("")
    public ResponseEntity<WeatherApiResponse> requestWeather(@RequestParam(name="lon", required = false) String lon,
                                                             @RequestParam(name="lat", required = false) String lat) {

        Optional<WeatherApiResponse> response = weatherService.requestDataFromApi(lat, lon);
        logger.info(response.toString());
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
