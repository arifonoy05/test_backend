package com.backend.test.features.restaurant;

import com.backend.test.features.restaurant.dto.RestaurantDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/restaurants", method = RequestMethod.GET)
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantService service;

    @GetMapping("/all")
    public ResponseEntity<?> getRestaurantList(){
        try{
            List<RestaurantEntity> restaurantEntityList = service.findAll();
            System.err.println(restaurantEntityList);
            return new ResponseEntity<>(restaurantEntityList, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> addNewRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        RestaurantEntity restaurant = service.addNewRestaurant(restaurantDTO);
        if(restaurant!=null){
            return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
