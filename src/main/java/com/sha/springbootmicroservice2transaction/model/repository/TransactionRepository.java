package com.sha.springbootmicroservice2transaction.model.repository;

import com.sha.springbootmicroservice2transaction.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{
    // select * from transactions where user_id = ?;
    // neye gore cekilecegi findAllBy + neye gore
    List<Transaction> findAllByUserID(Integer userID);
}
