package com.lab.inventory.data;

import com.lab.inventory.data.entity.TransactionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionHeaderRepository extends JpaRepository <TransactionHeader,Integer> {

    @Query(value = "select th from TransactionHeader th where th.status = :status")
    List<TransactionHeader> getByStatus(@Param("status") String status);
}
