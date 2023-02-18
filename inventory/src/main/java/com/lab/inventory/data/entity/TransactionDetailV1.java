package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@IdClass(TransactionDetailId.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="transaction_details_v1")
public class TransactionDetailV1 {
    @Id
    private Long transaction_id;
    /*@ManyToOne
    @JoinColumn(name="transaction_id", nullable=false)
    private TransactionHeaderV1 transactionHeader;*/
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
