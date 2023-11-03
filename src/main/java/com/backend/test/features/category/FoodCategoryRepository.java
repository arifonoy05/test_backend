package com.backend.test.features.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long>, JpaSpecificationExecutor<FoodCategoryEntity> {
}
