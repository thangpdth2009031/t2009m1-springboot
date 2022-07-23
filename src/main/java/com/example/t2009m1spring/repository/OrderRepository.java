package com.example.t2009m1spring.repository;

import com.example.t2009m1spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
