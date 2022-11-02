package com.lab.inventory;

import com.lab.inventory.data.entity.TransactionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHeaderRepository extends JpaRepository <TransactionHeader,Long> {
}
