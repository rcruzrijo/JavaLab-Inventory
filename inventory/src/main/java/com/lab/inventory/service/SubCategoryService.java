package com.lab.inventory.service;

import com.lab.inventory.data.entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    SubCategory save(SubCategory subCategory);

    SubCategory update(SubCategory subCategory);

    List<SubCategory> getAll();

    SubCategory findById(Integer id);

    List<SubCategory> findByCategoryId(Integer categoryId);
}
