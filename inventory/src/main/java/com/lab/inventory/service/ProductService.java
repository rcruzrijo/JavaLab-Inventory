package com.lab.inventory.service;

import com.lab.inventory.data.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    Product updateStatus(Product product);
    Product patch (Integer id, Map<Object, Object> fields);
    List<Product> getAll();

    List<Product> getAllActive();

    List<Product> getAllInactive();

    Product findById(Integer Id);

    List<Product> getFiltered(Map<String, String> filters);
}
