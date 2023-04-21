package com.payment.service;

import com.payment.entity.Payment;
import com.payment.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    public Payment savePayment( Payment payment){

        payment.setPaymentstatus(paymentProcessing());
        payment.setTransactionid(UUID.randomUUID().toString());
        payment.setOrderid(payment.getOrderid());
        paymentRepo.save(payment);

        return payment;
    }
    public String paymentProcessing(){

        return new Random().nextBoolean()?"success":"fail";
    }
    public Payment getPymentDetails(int  orderid) {
        Payment payment = paymentRepo.getByOrderId(orderid);

        if (payment!=null) {

           return  payment;
        }
        return  null;
    }

    public  Payment updatePaymentDetails(Payment payment){
        Payment payment1 = paymentRepo.getByOrderId(payment.getOrderid());
        if(payment1!=null){

          payment1.setAmount(payment.getAmount());
          payment1.setOrderid(payment.getOrderid());
          payment1.setPaymentstatus(payment.getPaymentstatus());
          payment1.setPaymentid(payment.getPaymentid());
            paymentRepo.save(payment1);
        return payment1;
        }
        return null;
    }

    }

