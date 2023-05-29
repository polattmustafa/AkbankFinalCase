package polat.mustafa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;
import polat.mustafa.dto.weather.WeatherDTO;
import polat.mustafa.dto.weather.WeatherSaveRequest;
import polat.mustafa.model.User;
import polat.mustafa.model.Weather;

import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WeatherMapper {

    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    Weather convertToWeather(WeatherSaveRequest request);

    WeatherDTO convertToWeatherDTO(Weather weather);

    List<WeatherDTO> convertToWeatherDTOList(List<Weather> weatherList);

}
