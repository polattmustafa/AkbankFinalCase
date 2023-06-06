package polat.mustafa.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import polat.mustafa.controller.contract.UserControllerContract;
import polat.mustafa.dto.user.UserDTO;
import polat.mustafa.dto.user.UserSaveRequest;
import polat.mustafa.general.RestResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

/**
 * @author MPolat
 */

public class UserControllerTest {

    @Mock
    private UserControllerContract userControllerContract;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        UserSaveRequest userSaveRequest = new UserSaveRequest("Mustafa", "Polat", "Mpolat", "12345", "mpolat@gmail.com");

        UserDTO userDTO = new UserDTO(1L, "Mustafa", "Polat", "Mpolat", "mpolat@gmail.com");

        when(userControllerContract.save(userSaveRequest)).thenReturn(userDTO);

        ResponseEntity<RestResponse<UserDTO>> response = userController.save(userSaveRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody().getData());

        verify(userControllerContract, times(1)).save(userSaveRequest);
    }

    @Test
    public void testFindAll() {
        UserDTO user1 = new UserDTO(1L, "Mustafa", "Polat", "Mpolat", "mpolat@gmail.com");
        UserDTO user2 = new UserDTO(2L, "Ali", "Veli", "aliveli", "aliveli@gmail.com");
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(user1);
        userDTOList.add(user2);

        when(userControllerContract.findAll()).thenReturn(userDTOList);

        ResponseEntity<RestResponse<List<UserDTO>>> response = userController.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTOList, response.getBody().getData());

        verify(userControllerContract, times(1)).findAll();
    }

    @Test
    public void testDelete() {
        Long userId = 1L;

        ResponseEntity<RestResponse<Object>> response = userController.delete(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody().getData());

        verify(userControllerContract, times(1)).delete(userId);
    }

    @Test
    public void testSetCity() {
        Long userId = 1L;
        Long cityId = 1L;

        UserDTO userDTO = new UserDTO(1L, "Mustafa", "Polat", "Mpolat", "mpolat@gmail.com");

        when(userControllerContract.setCity(userId, cityId)).thenReturn(userDTO);

        ResponseEntity<RestResponse<UserDTO>> response = userController.setCity(userId, cityId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDTO, response.getBody().getData());

        verify(userControllerContract, times(1)).setCity(userId, cityId);
    }


}
