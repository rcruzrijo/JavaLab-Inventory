package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TransactionDetailId implements Serializable {
    private Integer transaction_id;
    private Integer seq;

}
