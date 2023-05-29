package polat.mustafa.service;

import org.springframework.stereotype.Service;
import polat.mustafa.model.City;
import polat.mustafa.repository.CityRepository;

/**
 * @author MPolat
 */

@Service
public class CityService extends BaseEntityService<City, CityRepository>{
    public CityService(CityRepository anyRepo) {
        super(anyRepo);
    }
}
