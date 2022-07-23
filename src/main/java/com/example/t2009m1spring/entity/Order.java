package com.example.t2009m1spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private BigDecimal totalPrice;
    @JsonManagedReference
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false,foreignKey = @ForeignKey(name = "user_order_fk"))
//    @JsonManagedReference
//    private User user;
}
