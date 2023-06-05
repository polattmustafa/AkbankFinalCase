package polat.mustafa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import polat.mustafa.model.WeatherDb;

/**
 * @author MPolat
 */
public interface WeatherRepository extends JpaRepository<WeatherDb, Long> {
}
