package com.lab.inventory.service;

import com.lab.inventory.data.TransactionHeaderRepository;
import com.lab.inventory.data.entity.TransactionDetail;
import com.lab.inventory.data.entity.TransactionHeader;
import com.lab.inventory.util.exception.InvalidRequest;
import com.lab.inventory.util.exception.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionHeaderServiceImpl implements TransactionHeaderService {

    @Autowired
    TransactionHeaderRepository transactionHeaderRepository;

    @Autowired
    TransactionDetailService transactionDetailService;

    @Override
    @Transactional
    public TransactionHeader save (TransactionHeader transactionHeader){
        if (transactionHeader.getTransactionType().getId() == null)
            throw new InvalidRequest("Transaction Type should not be empty");
        if ( ("OUT".equals(transactionHeader.getTransactionType().getEfect()))
                && (transactionHeader.getCustomerId() == null) )
            throw new InvalidRequest("Customer should not be empty");
        if ( ("OUT".equals(transactionHeader.getTransactionType().getEfect()))
                && (transactionHeader.getCustomerReferenceId() == null || transactionHeader.getCustomerReferenceId().isEmpty()) )
            throw new InvalidRequest("Customer Reference should not be empty");
        if ( ("IN".equals(transactionHeader.getTransactionType().getEfect()))
                && (transactionHeader.getProviderId() == null ) )
            throw new InvalidRequest("Provider should not be empty");
        if ( ("IN".equals(transactionHeader.getTransactionType().getEfect()))
                && (transactionHeader.getProviderReferenceId() == null || transactionHeader.getProviderReferenceId().isEmpty()) )
            throw new InvalidRequest("Provider Reference should not be empty");
        if (transactionHeader.getDescription() == null || transactionHeader.getDescription().isEmpty())
            throw new InvalidRequest("Description should not be empty");
        if (transactionHeader.getTransactionDetails() == null || transactionHeader.getTransactionDetails().isEmpty())
            throw new InvalidRequest("Transaction has no Details");

        transactionHeader.setStatus("PENDING");

        transactionHeader.setTransactionDate(LocalDate.now());

        TransactionHeader transactionHeaderDB = transactionHeaderRepository.save(transactionHeader);

        transactionHeader.getTransactionDetails().forEach(detail -> {
            detail.setTransaction(transactionHeaderDB);
            transactionDetailService.save(detail);
        });

        return transactionHeaderDB;
    }

    @Override
    @Transactional
    public TransactionHeader update (TransactionHeader transactionHeader) {
        transactionHeader.getTransactionDetails().forEach(transactionDetailService::update);
        return transactionHeaderRepository
                .findById(transactionHeader.getId())
                .map(transactionHeaderDB -> {
                    transactionHeaderDB.setDescription(transactionHeader.getDescription());
                    transactionHeaderDB.setTransactionType(transactionHeader.getTransactionType());
                    transactionHeaderDB.setCustomerId(transactionHeader.getCustomerId());
                    transactionHeaderDB.setCustomerReferenceId(transactionHeader.getCustomerReferenceId());
                    transactionHeaderDB.setProviderId(transactionHeader.getProviderId());
                    transactionHeaderDB.setProviderReferenceId(transactionHeader.getProviderReferenceId());
                    transactionHeaderDB.setTransactionDate(transactionHeader.getTransactionDate());

                    return transactionHeaderRepository.save(transactionHeaderDB);
                }).orElseThrow(()->new NotFound("TransactionHeader with ID: "+transactionHeader.getId()+" Not Found!"));
    }

    @Override
    public TransactionHeader updateStatus (TransactionHeader transactionHeader) {
        return transactionHeaderRepository
                .findById(transactionHeader.getId())
                .map(transactionHeaderDB -> {
                    transactionHeaderDB.setStatus(transactionHeader.getStatus());
                    return transactionHeaderRepository.save(transactionHeaderDB);
                }).orElseThrow(()->new NotFound("TransactionHeader with ID: "+transactionHeader.getId()+" Not Found!"));
    }

    @Override
    public TransactionHeader findById(Long id) {
        return transactionHeaderRepository.findById(id)
                .orElseThrow(()-> new NotFound("TransactionHeader with id: "+id+" not Found"));

    }

    @Override
    public List<TransactionHeader> getAll() {
        return transactionHeaderRepository.findAll();
    }

    @Override
    public List<TransactionHeader> getAllPending() {
        return transactionHeaderRepository.getByStatus("PENDING");
    }

    @Override
    public List<TransactionHeader> getAllPosted() {
        return transactionHeaderRepository.getByStatus("POSTED");
    }

    @Override
    public List<TransactionHeader> getAllCancelled() {
        return transactionHeaderRepository.getByStatus("CANCELLED");
    }

    @Override
    public List<TransactionHeader> getAllRejected() {
        return transactionHeaderRepository.getByStatus("REJECTED");
    }

    @Override
    public List<TransactionHeader> getFiltered(Map<String, String> filters) {
        return transactionHeaderRepository.findAll()
                .stream().filter(transactionHeader -> filterTransactionHeader(transactionHeader, filters))
                .collect(Collectors.toList());
    }

    private boolean filterTransactionHeader(TransactionHeader transactionHeader, Map<String, String> filters){
        return filters.keySet().stream().allMatch(filter -> {
            final  String  filterValue = filters.get(filter);
            switch (filter){
                case "status": return filterValue.equals(transactionHeader.getStatus());
                case "TransactionType": return filterValue.equals(transactionHeader.getTransactionType());
                case "transactionDate": return filterValue.equals(transactionHeader.getTransactionDate());
                case "customerId": return filterValue.equals(transactionHeader.getCustomerId());
                case "providerId": return filterValue.equals(transactionHeader.getProviderId());
                case "description": return filterValue.contains(transactionHeader.getDescription());
            }
            return true;
        });
    }
}
