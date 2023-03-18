package com.lab.inventory.service;

import com.lab.inventory.data.repo.SubCategoryRepository;
import com.lab.inventory.data.entity.SubCategory;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public SubCategory save (SubCategory subCategory){
        if (subCategory.getDescription() == null || subCategory.getDescription().isEmpty())
            throw new InvalidRequest("Description should not be empty");

        if (subCategory.getCategory() == null)
            throw new InvalidRequest("Category_Id Must be specified");

        subCategory.setLastUpdated(LocalDate.now());

        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory update (SubCategory subCategory){
        return subCategoryRepository
                .findById(subCategory.getId())
                .map(subCategoryDB -> {
                    subCategoryDB.setDescription(subCategory.getDescription());
                    subCategoryDB.setCategory(subCategory.getCategory());
                    subCategoryDB.setLastUpdated(LocalDate.now());
                    return subCategoryRepository.save(subCategoryDB);
                }).orElseThrow(()->new NotFound("SubCategory with ID: "+subCategory.getId()+" Not Found!"));
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory findById(Integer id) {
        return subCategoryRepository.findById(id)
                .orElseThrow(()-> new NotFound("subCategory with id: "+id+" not Found"));

    }

    @Override
    public List<SubCategory> findByCategoryId(Integer categoryId) {
        return null;

    }
}
