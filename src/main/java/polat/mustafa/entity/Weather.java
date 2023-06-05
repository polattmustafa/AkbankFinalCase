package polat.mustafa.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author MPolat
 */

@Getter
@Setter
public class Weather {

    private long id;
    private String main;
    private String description;
    private String icon;
}
