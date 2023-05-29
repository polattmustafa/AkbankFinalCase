package polat.mustafa.dto.user;

/**
 * @author MPolat
 */
public record UserSaveRequest(String name,
                              String surname,
                              String username,
                              String password,
                              String email) {
}
