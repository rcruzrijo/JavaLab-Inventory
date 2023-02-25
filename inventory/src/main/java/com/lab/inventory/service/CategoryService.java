package com.lab.inventory.service;

import com.lab.inventory.data.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category update(Category category);
    List<Category> getAll();
    Category findById(Integer Id);
}
