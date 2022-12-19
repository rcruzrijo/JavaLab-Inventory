package com.lab.inventory.data;

import com.lab.inventory.data.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository <ProductImage, Long> {
}
