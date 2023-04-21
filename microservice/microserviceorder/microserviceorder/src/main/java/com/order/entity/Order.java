package com.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order_Table")
public class Order {
    @Id

    private int id;
    private String name;
    private int quantity;
    private double price;


}
