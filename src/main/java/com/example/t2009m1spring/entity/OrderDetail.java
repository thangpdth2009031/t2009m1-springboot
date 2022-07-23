package com.example.t2009m1spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId orderDetailId = new OrderDetailId();
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Product product;
    // thông tin thêm.
    private Integer quantity;
    private BigDecimal unitPrice;
}
