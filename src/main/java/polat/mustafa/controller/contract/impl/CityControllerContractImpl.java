package polat.mustafa.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import polat.mustafa.controller.contract.CityControllerContract;
import polat.mustafa.dto.city.CityDTO;
import polat.mustafa.dto.city.CitySaveRequest;
import polat.mustafa.mapper.CityMapper;
import polat.mustafa.model.City;
import polat.mustafa.service.CityService;

import java.util.List;

/**
 * @author MPolat
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class CityControllerContractImpl implements CityControllerContract {

    private final CityService cityService;

    @Override
    public CityDTO save(CitySaveRequest request) {
        log.info("Saving city: {}", request);
        City city = CityMapper.INSTANCE.convertToCity(request);
        city = cityService.save(city);

        return CityMapper.INSTANCE.convertToCityDTO(city);
    }

    @Override
    public void delete(Long id) {
        cityService.delete(id);
        log.info("City deleted successfully. ID: {}", id);
    }

    @Override
    public List<CityDTO> findAll() {
        log.info("Retrieving all cities");
        List<City> cityList = cityService.findAll();
        return CityMapper.INSTANCE.convertToCityDTOList(cityList);
    }

    @Override
    public CityDTO findCityByName(String name) {
        log.info("Finding city by name: {}", name);
        City city = cityService.findByName(name);
        return CityMapper.INSTANCE.convertToCityDTO(city);
    }

}
