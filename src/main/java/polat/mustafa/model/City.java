package polat.mustafa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author MPolat
 */

@Entity
@Table(name = "CITY")
@Getter
@Setter
public class City extends BaseModel{

    @Id
    @GeneratedValue(generator = "City", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "City", sequenceName = "CITY_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 70, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL,
               mappedBy = "city")
    private List<WeatherDb> weatherList;

    @ManyToMany(mappedBy = "citySet", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> userSet = new HashSet<>();

}
