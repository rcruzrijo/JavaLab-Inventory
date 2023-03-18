package com.lab.inventory.data.repo;

import com.lab.inventory.data.entity.TransactionHeaderV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHeaderV1Repository extends JpaRepository <TransactionHeaderV1, Long> {
}
