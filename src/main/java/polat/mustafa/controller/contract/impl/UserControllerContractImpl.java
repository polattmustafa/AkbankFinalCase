package polat.mustafa.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import polat.mustafa.controller.contract.UserControllerContract;
import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;
import polat.mustafa.mapper.UserMapper;
import polat.mustafa.model.City;
import polat.mustafa.model.User;
import polat.mustafa.service.CityService;
import polat.mustafa.service.UserService;

import java.util.List;
import java.util.Set;

/**
 * @author MPolat
 */

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserService userService;

    private final CityService cityService;

    @Override
    public UserDTO save(UserSaveRequest request) {
        User user = UserMapper.INSTANCE.convertToUser(request);
        user = userService.save(user);

        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userList = userService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOList(userList);
    }

    @Override
    public UserDTO setCity(Long id, Long cityId) {
        Set<City> citySet = null;
        User user = userService.findByIdWithControl(id);
        City city = cityService.findByIdWithControl(cityId);
        citySet = user.getCitySet();
        citySet.add(city);
        user.setCitySet(citySet);
        userService.save(user);

        return UserMapper.INSTANCE.convertToUserDTO(user);
    }
}
