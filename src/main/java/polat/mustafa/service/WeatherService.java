package polat.mustafa.service;

import org.springframework.stereotype.Service;
import polat.mustafa.model.WeatherDb;
import polat.mustafa.repository.WeatherRepository;

/**
 * @author MPolat
 */

@Service
public class WeatherService extends BaseEntityService<WeatherDb, WeatherRepository> {
    public WeatherService(WeatherRepository anyRepo) {
        super(anyRepo);
    }
}
