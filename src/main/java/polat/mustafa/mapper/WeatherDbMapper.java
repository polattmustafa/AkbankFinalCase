package polat.mustafa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import polat.mustafa.dto.weather.WeatherDTO;
import polat.mustafa.dto.weather.WeatherSaveRequest;
import polat.mustafa.model.WeatherDb;

import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherDbMapper {

    WeatherDbMapper INSTANCE = Mappers.getMapper(WeatherDbMapper.class);

    WeatherDb convertToWeather(WeatherSaveRequest request);

    WeatherDTO convertToWeatherDTO(WeatherDb weather);

    List<WeatherDTO> convertToWeatherDTOList(List<WeatherDb> weatherList);

}
