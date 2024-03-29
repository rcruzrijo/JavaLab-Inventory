package com.lab.inventory.data.repo;

import com.lab.inventory.data.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository <TransactionDetail, Integer> {

    @Query(value = "select td from TransactionDetail td where td.id = :transactionId")
    TransactionDetail getByTransactionId(@Param("transactionId") Integer transactionId);
}
