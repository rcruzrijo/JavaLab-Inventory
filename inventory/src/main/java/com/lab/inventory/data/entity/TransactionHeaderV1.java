package com.lab.inventory.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="transaction_header_v1")
public class TransactionHeaderV1 {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="transaction_date")
    private LocalDate transactionDate;
    @Column(name="customer_id")
    private Long customerId;
    @Column (name="customer_reference_id")
    private String  customerReferenceId;
    @Column(name="provider_id")
    private Long providerId;
    @Column(name="provider_reference_id")
    private String  providerReferenceId;
    @Column(name="status")
    private String  status;
    @OneToMany(mappedBy="transaction")
    private Set<TransactionDetail> transactionDetails;
}
