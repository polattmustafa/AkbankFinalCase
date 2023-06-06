package polat.mustafa.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import polat.mustafa.service.WeatherApiClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author MPolat
 */
public class WeatherControllerTest {

    @Mock
    private WeatherApiClient weatherApiClient;

    @InjectMocks
    private WeatherController weatherController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherForecast() {

    }

}
