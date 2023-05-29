package polat.mustafa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import polat.mustafa.service.WeatherService;

/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;



}
