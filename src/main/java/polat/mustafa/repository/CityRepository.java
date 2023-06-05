package polat.mustafa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import polat.mustafa.model.City;

/**
 * @author MPolat
 */
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByName(String name);

}
