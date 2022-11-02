package com.lab.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHeaderV1 extends JpaRepository <TransactionHeaderV1, Long> {
}
