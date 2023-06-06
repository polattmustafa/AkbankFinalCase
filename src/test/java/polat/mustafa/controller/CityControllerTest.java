package polat.mustafa.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import polat.mustafa.controller.contract.CityControllerContract;
import polat.mustafa.dto.city.CityDTO;
import polat.mustafa.dto.city.CitySaveRequest;
import polat.mustafa.general.RestResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author MPolat
 */

public class CityControllerTest {

    @Mock
    private CityControllerContract cityControllerContract;

    @InjectMocks
    private CityController cityController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        CitySaveRequest citySaveRequest = new CitySaveRequest("Istanbul");

        CityDTO cityDTO = new CityDTO(1L, "Istanbul");

        when(cityControllerContract.save(citySaveRequest)).thenReturn(cityDTO);

        ResponseEntity<RestResponse<CityDTO>> response = cityController.save(citySaveRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cityDTO, response.getBody().getData());

        verify(cityControllerContract, times(1)).save(citySaveRequest);
    }

    @Test
    public void testFindAll() {
        CityDTO city1 = new CityDTO(1L, "Istanbul");
        CityDTO city2 = new CityDTO(2L, "Ankara");
        List<CityDTO> cityDTOList = new ArrayList<>();
        cityDTOList.add(city1);
        cityDTOList.add(city2);

        when(cityControllerContract.findAll()).thenReturn(cityDTOList);

        ResponseEntity<RestResponse<List<CityDTO>>> response = cityController.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cityDTOList, response.getBody().getData());

        verify(cityControllerContract, times(1)).findAll();
    }

    @Test
    public void testDelete() {
        Long cityId = 1L;

        ResponseEntity<RestResponse<Object>> response = cityController.delete(cityId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody().getData());

        verify(cityControllerContract, times(1)).delete(cityId);
    }

    @Test
    public void testFindByName() {
        String cityName = "Istanbul";

        CityDTO cityDTO = new CityDTO(1L, "Istanbul");

        when(cityControllerContract.findCityByName(cityName)).thenReturn(cityDTO);

        ResponseEntity<RestResponse<CityDTO>> response = cityController.findByName(cityName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cityDTO, response.getBody().getData());

        verify(cityControllerContract, times(1)).findCityByName(cityName);
    }



}
