package polat.mustafa.dto.city;

import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.weather.WeatherDTO;

import java.util.List;
import java.util.Set;

/**
 * @author MPolat
 */
public record CityDTO(Long id,
                      String name,
                      Set<UserDTO> userDTOSet,
                      List<WeatherDTO> weatherList) {
}
