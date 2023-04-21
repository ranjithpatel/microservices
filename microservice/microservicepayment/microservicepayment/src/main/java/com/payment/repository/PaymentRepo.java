package com.payment.repository;

import com.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {
    @Query(value= "select * from payment_table where orderid =?1",nativeQuery = true)
    public Payment getByOrderId(int orderid);


}
