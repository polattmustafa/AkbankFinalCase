package polat.mustafa.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author MPolat
 */

@Getter
@Setter
public class MainData {

    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;

}
