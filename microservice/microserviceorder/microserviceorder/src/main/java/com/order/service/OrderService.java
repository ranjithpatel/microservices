package com.order.service;

import com.order.entity.Order;
import com.order.model.Payment;
import com.order.model.TransactionRequest;
import com.order.model.TransactionResponse;
import com.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderRepo orderRepo;

    public TransactionResponse saveOrder(TransactionRequest   request){
        String response="";
        Order order=request.getOrder();
        Payment payment=request.getPayment();
        payment.setOrderid(order.getId());
        payment.setAmount( order.getPrice());
        //rest call
       Payment payment1= restTemplate.postForObject("http://localhost:9191/payment/save",payment, Payment.class);
        response= payment1.getPaymentstatus().equalsIgnoreCase("success")?"payment success order placed":"payment failed order not placed";
         orderRepo.save(order);
         return new TransactionResponse(order,payment1.getAmount(),payment1.getTransactionid(),response);
    }

    public TransactionResponse getorderDetails(int id){

        Optional<Order> optional=orderRepo.findById(id);
        TransactionResponse response= new TransactionResponse();
        if(optional.isPresent()){
            Order order= optional.get();
            response.setOrder(order);
            Payment payment1= restTemplate.getForObject("http://localhost:9191/payment/get/"+order.getId(), Payment.class);

          String status=  payment1.getPaymentstatus();
          response.setResponse(status);
            double amount=  payment1.getAmount();
            response.setAmount(amount);
            String  transactionid= payment1.getTransactionid();
            response.setTransactionid(transactionid);
                return  response;
        }

        return null;
    }

    public TransactionResponse updateOrder(TransactionRequest request){
        Optional<Order> optional=orderRepo.findById(request.getOrder().getId());
        TransactionResponse response= new TransactionResponse();
        if(optional.isPresent()){
            optional.get();
            Order order= new Order();
            Payment payment=request.getPayment();
            payment.setAmount(order.getPrice());
            payment.setOrderid(order.getId());
          order.setId(request.getOrder().getId());
            order.setName(request.getOrder().getName());
            order.setPrice(request.getOrder().getPrice());
            order.setQuantity(request.getOrder().getQuantity());
//            HttpHeaders headers= new HttpHeaders();
//            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//            HttpEntity<Payment> entity=new HttpEntity<Payment>(payment,headers);

            restTemplate.put("http://localhost:9191/payment/update",payment,Payment.class);
    //            restTemplate.exchange("http://localhost:9191/payment/update",HttpMethod.PUT,entity,Payment.class);
            orderRepo.save(order);
            response.setOrder(order);
            return response;
        }
        return  null;
    }

}
