package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="transaction_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="transaction_detail_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name="transaction_id", nullable=false)
    private TransactionHeader transaction;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    @Column
    private Integer quantity;
    @Column(name="unit_price")
    private BigDecimal  unitPrice;

}
