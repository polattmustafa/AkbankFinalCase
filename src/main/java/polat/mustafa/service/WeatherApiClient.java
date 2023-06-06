package polat.mustafa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import polat.mustafa.model.City;
import polat.mustafa.model.WeatherDb;
import polat.mustafa.restmodel.List;
import polat.mustafa.restmodel.Root;

import java.util.ArrayList;


/**
 * @author MPolat
 */

@Component
public class WeatherApiClient {
    Logger logger = LoggerFactory.getLogger(WeatherApiClient.class);

    private final CityService cityService;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final WeatherService weatherService;

    @Value("${openweathermap.api.baseurl}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherApiClient(CityService cityService, RestTemplate restTemplate, ObjectMapper objectMapper, WeatherService weatherService) {
        this.cityService = cityService;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.weatherService = weatherService;
    }

    public Root getWeatherData(String name) throws Exception {
        City city = cityService.findByName(name);
        if (city == null) {
            logger.error("There is not that city => {} in database", name);
            return null;
        }
        String url = apiUrl + "?q=" + name + "&appid=" + apiKey+"&lang=tr&units=metric";
        logger.warn("URL=>"+url);

        ResponseEntity<Root> response = restTemplate.getForEntity(url, Root.class, city, apiKey);
        saveWeatherExecution(response, city);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("An error occurred while discarding the request to the OpenWeatherMap API. Error code: " + response.getStatusCodeValue());
        }

    }

    private void saveWeatherExecution(ResponseEntity<Root> response, City city) {
        WeatherDb weatherDb = new WeatherDb();
        weatherDb.setCity(city);
        ArrayList<List> weatherList = response.getBody().list;
        for (List weather: weatherList) {
            weatherDb.setTemperature(weather.main.temp);
            weatherDb.setHumidity((double) weather.main.humidity);
            weatherDb.setDescription(weather.weather.get(0).description);
            weatherService.save(weatherDb);
        }
    }

}
