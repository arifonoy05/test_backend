package com.backend.test.features.restaurant;

import com.backend.test.features.restaurant.dto.RestaurantDTO;
import com.backend.test.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repository;
    private final ModelMapper modelMapper;

    public List<RestaurantEntity> findAll(){
        return repository.findAll();
    }
    public RestaurantEntity findById(Long id){
        Optional<RestaurantEntity> restaurant = repository.findById(id);

        return restaurant.orElse(null);
    }

    public RestaurantEntity addNewRestaurant(RestaurantDTO restaurantDTO){
        try{
            RestaurantEntity restaurant = modelMapper.map(restaurantDTO, RestaurantEntity.class);
            restaurant.setCreatedAt(CommonUtils.currentTimeInMillisToTimestamp());
            restaurant.setCreatedBy(0L);
            restaurant.setCreatedByName("ADMIN");
            return repository.save(restaurant);
        }
        catch (Exception e){
            return null;
        }
    }
}
