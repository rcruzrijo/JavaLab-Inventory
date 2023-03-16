package com.lab.inventory.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTypeRequestDTO {
    @JsonProperty("description")
    private String  description;
    @JsonProperty("efect")
    private String  efect;
}
