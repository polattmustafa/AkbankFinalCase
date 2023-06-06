package polat.mustafa.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import polat.mustafa.restmodel.Root;
import polat.mustafa.service.WeatherApiClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * @author MPolat
 */
public class WeatherControllerTest {

    private WeatherController weatherController;

    @Mock
    private WeatherApiClient weatherApiClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        weatherController = new WeatherController(weatherApiClient);
    }

    @Test
    public void getWeatherForecast_ShouldCallWeatherApiClient_WithCorrectCity() throws Exception {
        String city = "Istanbul";

        weatherController.getWeatherForecast(city);

        verify(weatherApiClient).getWeatherData(city);
    }

    @Test
    public void getWeatherForecast_ShouldReturnWeatherDataFromApiClient() throws Exception {
        String city = "Istanbul";
        Root weatherData = new Root();

        when(weatherApiClient.getWeatherData(city)).thenReturn(weatherData);

        Root result = weatherController.getWeatherForecast(city);

        assertEquals(weatherData, result);
    }

    @Test
    public void getWeatherForecast_ShouldThrowException_WhenWeatherApiClientThrowsException() throws Exception {
        String city = "Istanbul";
        Exception exception = new Exception("Hava durumu verisi alınamadı.");

        when(weatherApiClient.getWeatherData(city)).thenThrow(exception);

        assertThrows(Exception.class, () -> weatherController.getWeatherForecast(city));
    }

}
