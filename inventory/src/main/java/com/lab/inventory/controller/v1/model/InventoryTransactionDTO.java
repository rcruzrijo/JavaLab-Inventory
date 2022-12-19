package com.lab.inventory.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lab.inventory.data.entity.TransactionDetail;
import com.lab.inventory.data.entity.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryTransactionDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("transactionType")
    private TransactionType transactionType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("transactionDate")
    private String transactionDate;
    @JsonProperty("customerId")
    private int customerId;
    @JsonProperty("customerReferenceId")
    private String customerReferenceId;
    @JsonProperty("providerId")
    private int providerId;
    @JsonProperty("providerReferenceId")
    private String providerReferenceId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("transactionDetails")
    private List<TransactionDetail> transactionDetails;
}
