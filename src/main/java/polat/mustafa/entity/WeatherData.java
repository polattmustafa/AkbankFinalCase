package polat.mustafa.entity;

import lombok.Getter;
import lombok.Setter;
import polat.mustafa.model.WeatherDb;

import java.util.List;

/**
 * @author MPolat
 */

@Getter
@Setter
public class WeatherData {

    private long dt;
    private MainData main;
    private List<Weather> weather;
}
