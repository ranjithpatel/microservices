package com.order.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    private int paymentid;
    private String paymentstatus;
    private String transactionid;
    private int orderid;
    private double amount;
}
