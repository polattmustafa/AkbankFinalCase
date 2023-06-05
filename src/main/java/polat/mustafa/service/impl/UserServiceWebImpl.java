package polat.mustafa.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import polat.mustafa.dto.UserDtoWeb;
import polat.mustafa.model.User;
import polat.mustafa.repository.UserRepository;
import polat.mustafa.service.UserServiceWeb;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MPolat
 */

@Service
public class UserServiceWebImpl implements UserServiceWeb {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceWebImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDtoWeb userDtoWeb) {
        User user = new User();
        user.setName(userDtoWeb.getFirstName() + " " + userDtoWeb.getLastName());
        user.setSurname(userDtoWeb.getLastName());
        user.setUsername(userDtoWeb.getUsername());
        user.setEmail(userDtoWeb.getEmail());
        user.setPassword(passwordEncoder.encode(userDtoWeb.getPassword()));

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDtoWeb> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDtoWeb convertEntityToDto(User user){
        UserDtoWeb userDtoWeb = new UserDtoWeb();
        userDtoWeb.setFirstName(user.getName());
        userDtoWeb.setLastName(user.getSurname());
        userDtoWeb.setUsername(user.getUsername());
        userDtoWeb.setEmail(user.getEmail());
        return userDtoWeb;
    }
}
