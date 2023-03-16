package com.lab.inventory.service;

import com.lab.inventory.data.entity.TransactionHeader;

import java.util.List;
import java.util.Map;

public interface TransactionHeaderService {
    TransactionHeader save(TransactionHeader transactionHeader);

    TransactionHeader update(TransactionHeader transactionHeader);

    TransactionHeader updateStatus(TransactionHeader transactionHeader);

    TransactionHeader patch (Integer id, Map<Object, Object> fields);

    TransactionHeader findById(Integer Id);

    List<TransactionHeader> getAll();

    List<TransactionHeader> getAllPending();

    List<TransactionHeader> getAllPosted();

    List<TransactionHeader> getAllRejected();

    List<TransactionHeader> getAllCancelled();

    List<TransactionHeader> getFiltered(Map<String, String> filters);
}
