package com.lab.inventory.data.repo;

import com.lab.inventory.data.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    /*@Query(value = "select sc from SubCategory sc th where sc.category_id = :categoryId")
    List<SubCategory> findByCategoryId(@Param("categoryId") Integer categoryId);*/

}
