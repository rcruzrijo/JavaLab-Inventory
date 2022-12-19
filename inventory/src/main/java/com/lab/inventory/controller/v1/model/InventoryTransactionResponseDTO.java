package com.lab.inventory.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lab.inventory.data.entity.TransactionHeader;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryTransactionResponseDTO {
    @JsonProperty("type")
    private String type;
    @JsonProperty("message")
    private String message;
    @JsonProperty("value")
    private List<TransactionHeader> value;
}
