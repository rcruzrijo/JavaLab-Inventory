package com.lab.inventory.service;

import com.lab.inventory.data.TransactionTypeRepository;
import com.lab.inventory.data.entity.TransactionType;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Override
    public TransactionType save (TransactionType transactionType){
        if (transactionType.getDescription() == null || transactionType.getDescription().isEmpty())
            throw new InvalidRequest("Description should not be empty");
        if (transactionType.getEfect() == null || transactionType.getEfect().isEmpty())
            throw new InvalidRequest("Efect should not be empty");

        return transactionTypeRepository.save(transactionType);
    }

    @Override
    public TransactionType update (TransactionType transactionType){
        return transactionTypeRepository
                .findById(transactionType.getId())
                .map(transactionTypeDB -> {
                    transactionTypeDB.setDescription(transactionType.getDescription());
                    transactionTypeDB.setEfect(transactionType.getEfect());
                    return transactionTypeRepository.save(transactionTypeDB);
                }).orElseThrow(()->new NotFound("TransactionType with ID: "+transactionType.getId()+" Not Found!"));
    }

    @Override
    public List<TransactionType> getAll() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public TransactionType findById(int id) {
        return transactionTypeRepository.findById(id)
                .orElseThrow(()-> new NotFound("TransactionType with id: "+id+" not Found"));

    }

}
