package polat.mustafa.service;

import polat.mustafa.dto.UserDtoWeb;
import polat.mustafa.model.User;

import java.util.List;

/**
 * @author MPolat
 */
public interface UserServiceWeb {

    void saveUser(UserDtoWeb userDtoWeb);

    User findByEmail(String email);

    List<UserDtoWeb> findAllUsers();

}
