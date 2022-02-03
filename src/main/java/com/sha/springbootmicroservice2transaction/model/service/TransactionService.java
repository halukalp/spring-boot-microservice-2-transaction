package com.sha.springbootmicroservice2transaction.model.service;

import com.sha.springbootmicroservice2transaction.model.entity.Transaction;
import com.sha.springbootmicroservice2transaction.util.Util;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService extends AbstractTransactionService
{
    @Override
    public List<Transaction> findAllTransactionsOfUser(Integer userID)
    {
        return transactionRepository.findAllByUserID(userID);
    }

    @Override
    public List<Transaction> findAll()
    {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction save(Transaction entity)
    {
        try
        {
            entity.setTransactionTime(new Date());
            return transactionRepository.save(entity);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
            return new Transaction();
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            transactionRepository.deleteById(id);
        }
        catch (IllegalArgumentException e)
        {
            Util.showExceptionInfo(e);
        }
    }
}
