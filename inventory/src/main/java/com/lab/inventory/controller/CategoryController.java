package com.lab.inventory.controller;

import com.lab.inventory.controller.v1.model.CategoryResponseDTO;
import com.lab.inventory.data.entity.Category;
import com.lab.inventory.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inventory/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public ResponseEntity <CategoryResponseDTO> getAllCategories() {
        return new ResponseEntity<>(CategoryResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(categoryServiceImpl.getAll()).build(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Category> getById(@PathVariable int id) {
        Category category = categoryServiceImpl.findById(id);

        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(category, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity <Category> create(@RequestBody Category newCategory) {
        Category category = categoryServiceImpl.save(newCategory);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(category, HttpStatus.BAD_REQUEST);
        }
        /*
        return new ResponseEntity<>(CategoryResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(categoryServiceImpl.save(category)).build(), HttpStatus.OK);
         */
    }

    @PutMapping("/{id}")
    public ResponseEntity <Category> update(@PathVariable int id, @RequestBody Category categoryDetails) {
        categoryDetails.setId(id);
        Category category = categoryServiceImpl.update(categoryDetails);

        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(category, HttpStatus.NOT_FOUND);
        }
    }
}
