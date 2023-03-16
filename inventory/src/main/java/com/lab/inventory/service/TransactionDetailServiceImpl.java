package com.lab.inventory.service;

import com.lab.inventory.data.TransactionDetailRepository;
import com.lab.inventory.data.entity.TransactionDetail;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService {
    @Autowired
    TransactionDetailRepository transactionDetailRepository;

    @Override
    public TransactionDetail save (TransactionDetail transactionDetail){
        Integer id_wrk = transactionDetail.getTransaction().getId();
        if (id_wrk  == null)
            throw new InvalidRequest("Transaction ID should not be empty");
        id_wrk = transactionDetail.getProduct().getId();
        if (id_wrk == null)
            throw new InvalidRequest("Product Id should not be empty");
        if (transactionDetail.getQuantity() == null)
            throw new InvalidRequest("Quantity should not be empty");
        if (transactionDetail.getUnitPrice() == null)
            throw new InvalidRequest("Unit Price should not be empty");

        return transactionDetailRepository.save(transactionDetail);
    }

    @Override
    public TransactionDetail update (TransactionDetail transactionDetail) {
        return transactionDetailRepository
                .findById(transactionDetail.getId())
                .map(transactionDetailDB -> {
                    transactionDetailDB.setTransaction(transactionDetail.getTransaction());
                    transactionDetailDB.setProduct(transactionDetail.getProduct());
                    transactionDetailDB.setQuantity(transactionDetail.getQuantity());
                    transactionDetailDB.setUnitPrice(transactionDetail.getUnitPrice());
                    return transactionDetailRepository.save(transactionDetailDB);
                }).orElseThrow(()->new NotFound("TransactionDetail with ID: "+transactionDetail.getId()+" Not Found!"));
    }
}
