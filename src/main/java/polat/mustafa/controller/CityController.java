package polat.mustafa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polat.mustafa.controller.contract.CityControllerContract;
import polat.mustafa.dto.city.CityDTO;
import polat.mustafa.dto.city.CitySaveRequest;
import polat.mustafa.general.RestResponse;

import java.util.List;

/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CityController {

    private final CityControllerContract cityControllerContract;

    @PostMapping("/save")
    public ResponseEntity<RestResponse<CityDTO>> save(@RequestBody CitySaveRequest citySaveRequest) {
        var cityDTO = cityControllerContract.save(citySaveRequest);
        return ResponseEntity.ok(RestResponse.of(cityDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<CityDTO>>> findAll() {
        var cityDTOList = cityControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(cityDTOList));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        cityControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
