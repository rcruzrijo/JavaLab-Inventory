package com.lab.inventory.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHeaderV1Repository extends JpaRepository <TransactionHeaderV1Repository, Long> {
}
