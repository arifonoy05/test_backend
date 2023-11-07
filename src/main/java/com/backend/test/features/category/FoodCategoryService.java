package com.backend.test.features.category;

import com.backend.test.features.category.dto.FoodCategoryDTO;
import com.backend.test.features.restaurant.RestaurantEntity;
import com.backend.test.features.restaurant.RestaurantService;
import com.backend.test.utils.CommonUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {
    private final FoodCategoryRepository repository;
    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;

    public List<FoodCategoryEntity> findAll(){
        return repository.findAll();
    }

    @Transactional
    public FoodCategoryEntity addNewFoodCategory(FoodCategoryDTO foodCategoryDTO){
        try{
            FoodCategoryEntity foodCategory = modelMapper.map(foodCategoryDTO, FoodCategoryEntity.class);

            RestaurantEntity restaurant = restaurantService.findById(foodCategoryDTO.getRestaurant_id());
            if(restaurant==null){
                throw new Exception("Restaurant of id::"+foodCategoryDTO.getRestaurant_id()+" is found null!");
            }
            foodCategory.setRestaurant(restaurant);

            foodCategory.setCreatedAt(CommonUtils.currentTimeInMillisToTimestamp());
            foodCategory.setCreatedBy(0L);
            foodCategory.setCreatedByName("ADMIN");

            return repository.save(foodCategory);
        }
        catch (Exception e){
            e.getMessage();
            return null;
        }
    }
}
