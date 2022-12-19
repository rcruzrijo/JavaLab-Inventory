package com.lab.inventory.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lab.inventory.data.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("subCategory")
    private SubCategory subCategory;
    @JsonProperty("lastUpdated")
    private String  lastUpdated;

}
