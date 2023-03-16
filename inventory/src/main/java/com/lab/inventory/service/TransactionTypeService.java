package com.lab.inventory.service;

import com.lab.inventory.data.entity.TransactionType;

import java.util.List;

public interface TransactionTypeService {

    TransactionType save(TransactionType transactionType);
    TransactionType update(TransactionType transactionType);
    List<TransactionType> getAll();
    TransactionType findById(int Id);
}
