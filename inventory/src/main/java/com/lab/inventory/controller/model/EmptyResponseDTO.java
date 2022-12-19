package com.lab.inventory.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmptyResponseDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
}
