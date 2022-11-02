package com.lab.inventory;

import com.lab.inventory.data.entity.TransactionDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailV1 extends JpaRepository <TransactionDetailV1, TransactionDetailId> {
}
