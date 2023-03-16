package com.lab.inventory.controller;

import com.lab.inventory.controller.v1.model.InventoryTransactionResponseDTO;
import com.lab.inventory.data.entity.TransactionHeader;
import com.lab.inventory.service.TransactionHeaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventory/transactions")
public class TransactionController {
    @Autowired
    private TransactionHeaderServiceImpl transactionHeaderServiceImpl;

    @GetMapping
    public ResponseEntity <InventoryTransactionResponseDTO> getAll() {
        return new ResponseEntity<>(InventoryTransactionResponseDTO.builder()
                .type("OK")
                .message("Success")
                .value(transactionHeaderServiceImpl.getAll()).build(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <TransactionHeader> getById(@PathVariable Integer id) {
        TransactionHeader transactionHeader = transactionHeaderServiceImpl.findById(id);

        if (transactionHeader != null) {
            return new ResponseEntity<>(transactionHeader, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transactionHeader, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity <TransactionHeader> create(@RequestBody TransactionHeader newTransactionHeader) {
        TransactionHeader transactionHeader = transactionHeaderServiceImpl.save(newTransactionHeader);
        if (transactionHeader != null) {
            return new ResponseEntity<>(transactionHeader, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(transactionHeader, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity <TransactionHeader> update(@PathVariable Integer id, @RequestBody TransactionHeader transactionHeaderDetail) {
        transactionHeaderDetail.setId(id);
        TransactionHeader transactionHeader = transactionHeaderServiceImpl.update(transactionHeaderDetail);

        if (transactionHeader != null) {
            return new ResponseEntity<>(transactionHeader, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transactionHeader, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity <TransactionHeader> patch(@PathVariable Integer id, @RequestBody Map<Object, Object> fields) {
        TransactionHeader transactionHeader = transactionHeaderServiceImpl.patch(id, fields);

        if (transactionHeader != null) {
            return new ResponseEntity<>(transactionHeader, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(transactionHeader, HttpStatus.NOT_FOUND);
        }
    }

}
