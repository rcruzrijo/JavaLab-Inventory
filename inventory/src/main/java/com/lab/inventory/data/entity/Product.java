package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="product_id_seq")
    private Long id;
    @Column
    private String description;
    @Column(name="unit_price")
    private BigDecimal unitPrice;
    @Column(name="stock_control")
    private String stockControl;
    @Column(name="available_qty")
    private BigDecimal availableQty;
    @Column(name="min_qty")
    private BigDecimal minQty;
    @Column(name="max_qty")
    private BigDecimal maxQty;
    @Column
    private String status;
    @ManyToOne
    @JoinColumn(name="sub_category_id", nullable=false)
    private SubCategory subCategory;
    @OneToMany(mappedBy="product")
    private Set<ProductImage> productImages;
}
