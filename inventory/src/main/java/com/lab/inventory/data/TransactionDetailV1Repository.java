package com.lab.inventory.data;

import com.lab.inventory.data.entity.TransactionDetailId;
import com.lab.inventory.data.entity.TransactionDetailV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailV1Repository extends JpaRepository <TransactionDetailV1, TransactionDetailId> {
}
