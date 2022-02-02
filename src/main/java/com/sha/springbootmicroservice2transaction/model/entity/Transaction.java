package com.sha.springbootmicroservice2transaction.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TRANSACTION")
public class Transaction
{
    @Id
    @Column(name = "TRANSACTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer transactionID;

    @Column(name = "USER_ID", nullable = false)
    private Integer userID;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productID;

    @Temporal(TemporalType.DATE)
    @Column(name = "TRANSACTION_TIME")
    private Date transactionTime;
}
