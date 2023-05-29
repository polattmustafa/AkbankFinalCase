package polat.mustafa.service;

import org.springframework.stereotype.Service;
import polat.mustafa.model.User;
import polat.mustafa.repository.UserRepository;

/**
 * @author MPolat
 */

@Service
public class UserService extends BaseEntityService<User, UserRepository> {

    public UserService(UserRepository anyRepo) {
        super(anyRepo);
    }

}
