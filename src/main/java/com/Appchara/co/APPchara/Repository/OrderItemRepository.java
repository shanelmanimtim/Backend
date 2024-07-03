package com.Appchara.co.APPchara.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Appchara.co.APPchara.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}