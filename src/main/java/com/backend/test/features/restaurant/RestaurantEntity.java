package com.backend.test.features.restaurant;

import com.backend.test.features.category.FoodCategoryEntity;
import com.backend.test.utils.model.CommonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEntity extends CommonProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<FoodCategoryEntity> foodCategoryEntities = new ArrayList<>();
}
