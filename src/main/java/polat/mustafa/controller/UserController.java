package polat.mustafa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polat.mustafa.controller.contract.UserControllerContract;
import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;
import polat.mustafa.general.RestResponse;

import java.util.List;


/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    //logging could be like this but I am using Slf4j this time
    //private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserControllerContract userControllerContract;

    @PostMapping("/save")
    public ResponseEntity<RestResponse<UserDTO>> save(@RequestBody UserSaveRequest userSaveRequest) {
        var userDTO = userControllerContract.save(userSaveRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        userControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PutMapping("/{userId}/city/{cityId}")
    public ResponseEntity<RestResponse<UserDTO>> setCity(@PathVariable Long userId,
                                                         @PathVariable Long cityId) {
        var userDto = userControllerContract.setCity(userId, cityId);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

}
