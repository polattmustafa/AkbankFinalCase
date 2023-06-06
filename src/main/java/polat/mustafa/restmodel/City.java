package polat.mustafa.restmodel;

/**
 * @author MPolat
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import polat.mustafa.model.WeatherDb;

import java.util.List;

/**
 * @author MPolat
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    public int id;
    public String name;
    public Coord coord;
    public String country;
    public int population;
    public int timezone;
    public int sunrise;
    public int sunset;
}


