package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@IdClass(TransactionDetailId.class)
@AllArgsConstructor
@Builder
@Table(name="transaction_details_v1")
public class TransactionDetailV1 {
    @Id
    @ManyToOne
    @JoinColumn(name="transaction_id", nullable=false)
    private TransactionHeader transaction;
    @Id
    private Integer seq;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    @Column
    private Integer quantity;
    @Column(name="unit_price")
    private BigDecimal unitPrice;
}
