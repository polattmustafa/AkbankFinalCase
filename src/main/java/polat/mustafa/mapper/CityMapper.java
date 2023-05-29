package polat.mustafa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import polat.mustafa.dto.city.CityDTO;
import polat.mustafa.dto.city.CitySaveRequest;
import polat.mustafa.model.City;
import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City convertToCity(CitySaveRequest request);

    CityDTO convertToCityDTO(City city);

    List<CityDTO> convertToCityDTOList(List<City> cityList);

}
