package com.lab.inventory.service;

import com.lab.inventory.data.CategoryRepository;
import com.lab.inventory.data.entity.Category;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category save (Category category){
        if (category.getDescription() == null || category.getDescription().isEmpty())
            throw new InvalidRequest("Description should not be empty");
        category.setLastUpdated(LocalDate.now());

        return categoryRepository.save(category);
    }

    @Override
    public Category update (Category category){
        return categoryRepository
                .findById(category.getId())
                .map(categoryDB -> {
                    categoryDB.setDescription(category.getDescription());
                    categoryDB.setLastUpdated(LocalDate.now());
                    return categoryRepository.save(categoryDB);
                }).orElseThrow(()->new NotFound("Category with ID: "+category.getId()+" Not Found!"));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new NotFound("Category with id: "+id+" not Found"));

    }

}
