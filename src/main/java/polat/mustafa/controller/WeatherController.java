package polat.mustafa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import polat.mustafa.entity.WeatherApiResponse;
import polat.mustafa.service.WeatherApiClient;

/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherApiClient weatherApiClient;

    @GetMapping("/{city}")
    public WeatherApiResponse getWeatherForecast(@PathVariable String city) {
        WeatherApiResponse weatherApiResponse = weatherApiClient.getWeatherForecast(city);
        return weatherApiResponse;
    }

}
