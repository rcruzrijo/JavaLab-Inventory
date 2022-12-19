package com.lab.inventory.data;

import com.lab.inventory.data.entity.TransactionDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailV1Repository extends JpaRepository <TransactionDetailV1Repository, TransactionDetailId> {
}
