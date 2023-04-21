package com.payment.controller;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/save")
    public Payment dopayment(@RequestBody Payment payment){

        return paymentService.savePayment(payment);
    }
    @GetMapping("/get/{id}")
    public Payment getPaymentDetails(@PathVariable("id") int userid){
        return paymentService.getPymentDetails(userid);
    }
    @PutMapping("/update")
    public Payment updateDetails(@RequestBody Payment payment){
        return paymentService.updatePaymentDetails( payment);

    }
}
