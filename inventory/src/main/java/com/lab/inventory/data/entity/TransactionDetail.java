package com.lab.inventory.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="transaction_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="transaction_detail_id_seq")
    private int id;
    @ManyToOne
    @JoinColumn(name="transaction_id", nullable=false)
    @JsonIgnore
    private TransactionHeader transaction;
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
    @Column
    private Integer quantity;
    @Column(name="unit_price")
    private BigDecimal  unitPrice;

}
