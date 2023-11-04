package com.backend.test.features.category;

import com.backend.test.features.category.dto.FoodCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/foodCategory", method = RequestMethod.GET)
@RequiredArgsConstructor
public class FoodCategoryRestController {
    private final FoodCategoryService service;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        try{
            List<FoodCategoryEntity> foodCategoryEntities = service.findAll();
            return new ResponseEntity<>(foodCategoryEntities, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> addNewFoodCategory(@RequestBody FoodCategoryDTO foodCategoryDTO){
        FoodCategoryEntity foodCategory = service.addNewFoodCategory(foodCategoryDTO);
        if(foodCategory!=null){
            return new ResponseEntity<>(foodCategory, HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
