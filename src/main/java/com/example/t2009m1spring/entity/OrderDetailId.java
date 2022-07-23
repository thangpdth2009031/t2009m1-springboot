package com.example.t2009m1spring.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class OrderDetailId implements Serializable {  //sử dụng serializable sử dụng để có thể dọc, ghi ra file, một class có composite key buộc phải cso @Embeddable và implements Serializable
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "product_id")
    private Integer productId;
}
