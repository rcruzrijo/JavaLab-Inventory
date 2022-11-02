package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="transaction_type")
public class TransactionType {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String description;
    @Column
    private String efect;
}
