package com.backend.test.features.category.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCategoryDTO {
    private String name;
    private boolean active;
    private Long restaurant_id;
}
