package polat.mustafa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import polat.mustafa.restmodel.Root;
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
    public Root getWeatherForecast(@PathVariable String city) {
        return weatherApiClient.getWeatherData(city);
    }

}
