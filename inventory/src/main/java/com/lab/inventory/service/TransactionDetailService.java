package com.lab.inventory.service;

import com.lab.inventory.data.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {

    TransactionDetail save(TransactionDetail transactionDetail);

    TransactionDetail update(TransactionDetail transactionDetail);

}
