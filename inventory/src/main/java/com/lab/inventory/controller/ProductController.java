package com.lab.inventory.controller;

import com.lab.inventory.controller.v1.model.ProductResponseDTO;
import com.lab.inventory.data.entity.Product;
import com.lab.inventory.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventory/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping
    public ResponseEntity <ProductResponseDTO> getAllProducts() {
        return new ResponseEntity<>(ProductResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(productServiceImpl.getAll()).build(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Product> getById(@PathVariable Integer id) {
        Product product = productServiceImpl.findById(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity <Product> create(@RequestBody Product newProduct) {
        Product product = productServiceImpl.save(newProduct);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(product, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <Product> update(@PathVariable Integer id, @RequestBody Product productDetails) {
        productDetails.setId(id);
        Product product = productServiceImpl.update(productDetails);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity <Product> patch(@PathVariable Integer id, @RequestBody Map<Object, Object> fields) {
        Product product = productServiceImpl.patch(id, fields);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);
        }
    }

}
