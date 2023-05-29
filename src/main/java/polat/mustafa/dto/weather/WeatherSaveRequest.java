package polat.mustafa.dto.weather;

/**
 * @author MPolat
 */
public record WeatherSaveRequest(Double temperature,
                                 Double humidity,
                                 String description,
                                 Double lon,
                                 Double lat,
                                 Long cityId) {
}
