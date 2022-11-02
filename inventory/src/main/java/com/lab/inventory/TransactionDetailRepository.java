package com.lab.inventory;

import com.lab.inventory.data.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository <TransactionDetail, Long> {
}
