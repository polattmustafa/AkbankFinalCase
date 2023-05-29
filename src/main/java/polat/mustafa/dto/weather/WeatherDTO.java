package polat.mustafa.dto.weather;

/**
 * @author MPolat
 */
public record WeatherDTO(Long id,
                         Double temperature,
                         Double humidity,
                         String description,
                         Long cityId) {
}
