package com.example.t2009m1spring.product;

import com.example.t2009m1spring.T2009m1SpringApplication;
import com.example.t2009m1spring.entity.*;
import com.example.t2009m1spring.repository.CategoryRepository;
import com.example.t2009m1spring.repository.OrderRepository;
import com.example.t2009m1spring.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {T2009m1SpringApplication.class})
public class SaveProduct {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void saveProduct() {
        Category category = Category.builder()
                .name("banh")
                .build();
        categoryRepository.save(category);
        Product product = Product.builder()
                .category(category)
                .name("banh mi")
                .build();
        Product product1 = Product.builder()
                .category(category)
                .name("banh ran")
                .build();
        productRepository.save(product);
        productRepository.save(product1);

        List<Product> products = productRepository.findAll();
        Order order = Order.builder()
                .totalPrice(new BigDecimal(2222))
                .build();
        HashSet<OrderDetail> orderDetails = new HashSet<>();
        for (Product product2: products) {
            OrderDetail orderDetail = OrderDetail.builder()
                    .orderDetailId(OrderDetailId.builder()
                            .orderId(order.getId())
                            .productId(product.getId())
                            .build())
                    .order(order)
                    .quantity(10)
                    .unitPrice(new BigDecimal(100))
                    .build();
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);
        orderRepository.save(order);
        System.out.println("Ok");
    }
}
