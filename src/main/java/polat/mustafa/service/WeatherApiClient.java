package polat.mustafa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import polat.mustafa.controller.contract.CityControllerContract;
import polat.mustafa.entity.WeatherApiResponse;
import polat.mustafa.model.City;


/**
 * @author MPolat
 */

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final CityControllerContract cityControllerContract;

    @Value("${openweathermap.api.baseurl}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherApiClient(RestTemplate restTemplate, ObjectMapper objectMapper, CityControllerContract cityControllerContract) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.cityControllerContract = cityControllerContract;
    }

    public WeatherApiResponse getWeatherForecast(String city) {
        var cityDb = cityControllerContract.findCityByName(city);

        // API'ye istek at
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);

        try {
            WeatherApiResponse weatherApiResponse = objectMapper.readValue(response, WeatherApiResponse.class);

            return weatherApiResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
