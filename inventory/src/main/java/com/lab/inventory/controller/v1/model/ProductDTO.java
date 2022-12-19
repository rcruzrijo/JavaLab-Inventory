package com.lab.inventory.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lab.inventory.data.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String  description;
    @JsonProperty("categoryId")
    private int categoryId;
    @JsonProperty("categoryDesc")
    private String  categoryDesc;
    @JsonProperty("subCategoryId")
    private int subCategoryId;
    @JsonProperty("subCategoryDesc")
    private String  subCategoryDesc;
    @JsonProperty("unitPrice")
    private DecimalFormat unitPrice;
    @JsonProperty("stockControl")
    private boolean stockControl;
    @JsonProperty("availableQty")
    private int availableQty;
    @JsonProperty("minQty")
    private int minQty;
    @JsonProperty("maxQty")
    private int maxQty;
    @JsonProperty("productImages")
    private List<ProductImage>  productImages;
    @JsonProperty("status")
    private String  status;
}
