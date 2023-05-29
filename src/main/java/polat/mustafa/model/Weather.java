package polat.mustafa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MPolat
 */

@Entity
@Table(name = "WEATHER")
@Getter
@Setter
public class Weather extends BaseModel{

    @Id
    @GeneratedValue(generator = "Weather", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Weather", sequenceName = "WEATHER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    @Column(name = "HUMIDITY")
    private Double humidity;

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LON")
    private Double lon;

    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CITY", nullable = false)
    private City city;

}
