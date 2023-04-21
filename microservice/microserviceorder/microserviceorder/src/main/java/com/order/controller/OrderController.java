package com.order.controller;

import com.order.entity.Order;
import com.order.model.TransactionRequest;
import com.order.model.TransactionResponse;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService ;
    @PostMapping("/save")
    public TransactionResponse saveOrder(@RequestBody TransactionRequest request){

        return orderService.saveOrder(request);
    }

    @GetMapping("/get/{id}")
    public TransactionResponse getOrderDetails(@PathVariable("id")int orderid){
        return orderService.getorderDetails(orderid);
    }

    @PutMapping("/update")
    public TransactionResponse updateOrderDetails(@RequestBody  TransactionRequest request){
        return orderService.updateOrder(request);
    }
}
