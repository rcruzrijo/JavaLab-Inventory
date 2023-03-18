package com.lab.inventory.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="transaction_header")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHeader {
    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY, generator="transaction_header_id_seq")
    private int id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="transaction_type_id", nullable=false)
    private TransactionType transactionType;
    @Column(name="transaction_date")
    private LocalDate transactionDate;
    @Column(name="customer_id")
    private int customerId;
    @Column (name="customer_reference_id")
    private String  customerReferenceId;
    @Column(name="provider_id")
    private int providerId;
    @Column(name="provider_reference_id")
    private String  providerReferenceId;
    @Column
    private String description;
    @Column(name="status")
    private String  status;
    @OneToMany(mappedBy="transaction")
    private Set<TransactionDetail> transactionDetails;

}
