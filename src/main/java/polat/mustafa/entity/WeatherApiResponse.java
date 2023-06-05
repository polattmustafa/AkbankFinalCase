package polat.mustafa.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author MPolat
 */

@Getter
@Setter
public class WeatherApiResponse {

    private String cod;
    private int message;
    private int cnt;
    private List<WeatherData> weatherDataList;

}
