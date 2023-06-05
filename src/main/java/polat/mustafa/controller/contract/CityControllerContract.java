package polat.mustafa.controller.contract;

import polat.mustafa.dto.city.CityDTO;
import polat.mustafa.dto.city.CitySaveRequest;

import java.util.List;

/**
 * @author MPolat
 */
public interface CityControllerContract {

    CityDTO save(CitySaveRequest request);

    void delete(Long id);

    List<CityDTO> findAll();

    CityDTO findCityByName(String city);

}
