package com.sha.springbootmicroservice2transaction.controller;

import com.sha.springbootmicroservice2transaction.model.entity.Transaction;
import com.sha.springbootmicroservice2transaction.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService service;

    @GetMapping("{userID}")
    public ResponseEntity<List<Transaction>> getTransactionOfUser(@PathVariable Integer userID)
    {
        return ResponseEntity.ok(service.findAllTransactionsOfUser(userID));
    }

    // api/transaction
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions()
    {
        List<Transaction> transactionList = service.findAll();

        return ResponseEntity.ok(transactionList); // cevabın döndürülmesi
    }

    // api/product
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction)
    {
        Transaction savedTransaction = service.save(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @DeleteMapping("{transactionID}") // api/product/transactionID
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable  Integer transactionID)
    {
        service.deleteByID(transactionID);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}