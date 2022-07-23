package com.example.t2009m1spring.seeder;

import com.example.t2009m1spring.entity.Order;
import com.example.t2009m1spring.entity.enums.OrderSeedByTimeType;
import com.example.t2009m1spring.entity.enums.OrderSimpleStatus;
import com.example.t2009m1spring.repository.OrderRepository;
import com.example.t2009m1spring.util.DateTimeHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderSeeder {
    public static List<Order> orders;
    public static final int NUMBER_OF_ORDER = 1000;
    public static final int NUMBER_OF_DONE = 600;
    public static final int NUMBER_OF_CANCEL = 200;
    public static final int NUMBER_OF_PENDING = 200;
    public static final int MIN_ORDER_DETAIL =2;
    public static final int MAX_ORDER_DETAIL =5;
    public static final int MIN_PRODUCT_QUANTITY =1;
    public static final int MAX_PRODUCT_QUANTITY =5;

    @Autowired
    OrderRepository orderRepository;
    List<OrderSeederByTime> seeder;

    public void configData() {
        seeder = new ArrayList<>();
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.DAY).day(18).month(Month.JUNE).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.DAY).day(17).month(Month.JUNE).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.MONTH).month(Month.JUNE).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.PROCESSING).seedTypeByTime(OrderSeedByTimeType.MONTH).month(Month.JUNE).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.MONTH).month(Month.MAY).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.PROCESSING).seedTypeByTime(OrderSeedByTimeType.MONTH).month(Month.APRIL).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.DAY).day(18).month(Month.JUNE).year(2022)
                        .build());
        seeder.add(
                OrderSeederByTime.builder()
                        .orderStatus(OrderSimpleStatus.DONE).seedTypeByTime(OrderSeedByTimeType.DAY).day(18).month(Month.JUNE).year(2022)
                        .build());
    }

//    private LocalDateTime calculateOrderCreatedTime(OrderSeederByTime orderSeederByTime) {
//        LocalDateTime result = null;
//        LocalDateTime tempLocalDateTime = null;
//        int tempMonth = 1;
//        int tempYear = 2022;
//        switch (orderSeederByTime.getSeedTypeByTime()) {
//            case YEAR:
//                tempMonth = DateTimeHelper.getRandomMonth().getValue();
//                tempYear = orderSeederByTime.getYear();
//                tempLocalDateTime = LocalDateTime.of(tempYear, tempMonth, 1, 0, 0, 0);
//                result = tempLocalDateTime.plusMonths(1).minusDays(1);
//                break;
//            case MONTH:
//                tempMonth = orderSeederByTime.getMonth().getValue();
//                tempYear = orderSeederByTime.getYear();
//                tempLocalDateTime = LocalDateTime.of(tempYear, tempMonth, 1, 0, 0, 0);
//                LocalDateTime lastDayOfMonth = tempLocalDateTime.plusMonths(1).minusDays(1);
//                int randomDay = NumberUtil
//
//        }
//    }
}
