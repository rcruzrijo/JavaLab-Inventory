package com.lab.inventory.controller;

import com.lab.inventory.controller.v1.model.CategoryResponseDTO;
import com.lab.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/inventory/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity <CategoryResponseDTO> getAllCategories() {
        return new ResponseEntity<>(CategoryResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(categoryService.getAll()).build(), HttpStatus.OK);
    }

}
