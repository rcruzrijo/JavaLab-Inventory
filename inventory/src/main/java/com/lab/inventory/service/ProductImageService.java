package com.lab.inventory.service;

import com.lab.inventory.data.entity.ProductImage;

import java.util.List;

public interface ProductImageService {

    ProductImage save(ProductImage productImage);

    ProductImage update(ProductImage productImage);

    List<ProductImage> getAll();

    ProductImage findById(Long Id);

    ProductImage findByProductId(Long ProductId);
}
