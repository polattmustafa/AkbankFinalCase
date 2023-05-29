package polat.mustafa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import polat.mustafa.model.Weather;

/**
 * @author MPolat
 */
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
