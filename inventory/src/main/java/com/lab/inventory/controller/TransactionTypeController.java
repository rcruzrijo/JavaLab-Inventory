package com.lab.inventory.controller;

import com.lab.inventory.controller.v1.model.TransactionTypeResponseDTO;
import com.lab.inventory.data.entity.TransactionType;
import com.lab.inventory.service.TransactionTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/transactionType")
public class TransactionTypeController {
    @Autowired
    private TransactionTypeServiceImpl transactionTypeServiceImpl;

    @GetMapping
    public ResponseEntity <TransactionTypeResponseDTO> getAllTransactionTypes() {
        return new ResponseEntity<>(TransactionTypeResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(transactionTypeServiceImpl.getAll()).build(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <TransactionType> getById(@PathVariable int id) {
        TransactionType transactionType = transactionTypeServiceImpl.findById(id);

        if (transactionType != null) {
            return new ResponseEntity<>(transactionType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transactionType, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity <TransactionType> create(@RequestBody TransactionType newTransactionType) {
        TransactionType transactionType = transactionTypeServiceImpl.save(newTransactionType);
        if (transactionType != null) {
            return new ResponseEntity<>(transactionType, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(transactionType, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <TransactionType> update(@PathVariable int id, @RequestBody TransactionType transactionTypeDetails) {
        transactionTypeDetails.setId(id);
        TransactionType transactionType = transactionTypeServiceImpl.update(transactionTypeDetails);

        if (transactionType != null) {
            return new ResponseEntity<>(transactionType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transactionType, HttpStatus.NOT_FOUND);
        }
    }
}
