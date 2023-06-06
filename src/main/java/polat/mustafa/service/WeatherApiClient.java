package polat.mustafa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import polat.mustafa.restmodel.Root;


/**
 * @author MPolat
 */

@Component
public class WeatherApiClient {
    Logger logger = LoggerFactory.getLogger(WeatherApiClient.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${openweathermap.api.baseurl}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    public WeatherApiClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Root getWeatherData(String city) {
        String url = apiUrl + "?q=" + city + "&appid=" + apiKey+"&lang=tr&units=metric";
        logger.warn("URL=>"+url);

        ResponseEntity<Root> response = restTemplate.getForEntity(url, Root.class, city, apiKey);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("OpenWeatherMap API'ye istek atılırken bir hata oluştu. Hata kodu: " + response.getStatusCodeValue());
        }

    }

}
