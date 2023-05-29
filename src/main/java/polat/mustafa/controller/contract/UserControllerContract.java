package polat.mustafa.controller.contract;

import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;

import java.util.List;

/**
 * @author MPolat
 */
public interface UserControllerContract {

    UserDTO save(UserSaveRequest request);

    void delete(Long id);

    List<UserDTO> findAll();

    UserDTO setCity(Long id, Long cityId);
}
