package com.lab.inventory.data.entity;

import java.io.Serializable;

public class TransactionDetailId implements Serializable {
    private Long transactionId;
    private Integer seq;

    public TransactionDetailId(Long transactionId, Integer seq) {
        this.transactionId = transactionId;
        this.seq = seq;
    }
}
