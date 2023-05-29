package polat.mustafa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;
import polat.mustafa.model.User;

import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User convertToUser(UserSaveRequest request);

    UserDTO convertToUserDTO(User user);

    List<UserDTO> convertToUserDTOList(List<User> userList);

}
