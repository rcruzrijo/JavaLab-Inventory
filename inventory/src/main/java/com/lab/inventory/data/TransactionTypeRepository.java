package com.lab.inventory.data;

import com.lab.inventory.data.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository <TransactionType, Long> {
}
