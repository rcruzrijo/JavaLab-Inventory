package com.lab.inventory.service;

import com.lab.inventory.data.ProductImageRepository;
import com.lab.inventory.data.entity.ProductImage;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageRepository productImageRepository;

    public ProductImage save (ProductImage productImage){
        if (productImage.getUrl() == null || productImage.getUrl().isEmpty())
            throw new InvalidRequest("URL should not be empty");

        if (productImage.getProduct() == null)
            throw new InvalidRequest("Product_Id Must be specified");

        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage update (ProductImage productImage){
        return productImageRepository
                .findById(productImage.getId())
                .map(productImageDB -> {
                    productImageDB.setUrl(productImage.getUrl());
                    productImageDB.setProduct(productImage.getProduct());
                    return productImageRepository.save(productImageDB);
                }).orElseThrow(()->new NotFound("ProductImage with ID: "+productImage.getId()+" Not Found!"));
    }

    @Override
    public List<ProductImage> getAll() {
        return productImageRepository.findAll();
    }

    @Override
    public ProductImage findById(Long id) {
        return productImageRepository.findById(id)
                .orElseThrow(()-> new NotFound("productImage with id: "+id+" not Found"));

    }

    @Override
    public ProductImage findByProductId(Long id) {
        return null;

    }



}
