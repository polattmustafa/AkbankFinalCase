package polat.mustafa.dto.user;

import polat.mustafa.dto.city.CityDTO;

import java.util.Set;

/**
 * @author MPolat
 */
public record UserDTO(Long id,
                      String name,
                      String surname,
                      String username,
                      String email,
                      Set<CityDTO> citySet) {
}
