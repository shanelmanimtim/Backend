package com.Appchara.co.APPchara.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {
    
    private @Id
    @GeneratedValue Long OrderId;
    public Long UserId;
    private double TotalAmount;
    private String Status;
    
    Order(){}

    public Order(Long userId, double totalAmount, String status) {
        UserId = userId;
        TotalAmount = totalAmount;
        Status = status;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public void setTotalAmount(double totalAmount) {
        TotalAmount = totalAmount;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public Long getUserId() {
        return UserId;
    }

    public double getTotalAmount() {
        return TotalAmount;
    }

    public String getStatus() {
        return Status;
    }  

}
