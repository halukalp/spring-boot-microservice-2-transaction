package com.sha.springbootmicroservice2transaction.model.service;

import com.sha.springbootmicroservice2transaction.model.entity.Transaction;
import com.sha.springbootmicroservice2transaction.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction, Integer>
{
    @Autowired
    protected TransactionRepository transactionRepository;

    public abstract List<Transaction> findAllTransactionsOfUser(Integer userID);
}
