package com.example.t2009m1spring.seeder;

import com.example.t2009m1spring.entity.enums.OrderSeedByTimeType;
import com.example.t2009m1spring.entity.enums.OrderSimpleStatus;
import lombok.*;

import java.time.Month;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSeederByTime {
    /**
     * Loại này gồm 3 kiểu:
     * - Theo ngày (generate chính xác theo ngày tháng năm)
     * - Theo tháng (generate chính xác theo tháng và năm, ngày sinh random)
     * - Theo năm (generate chính xác theo năm, ngày sinh và tháng random)
     * */
    private OrderSeedByTimeType seedTypeByTime;
    private int year;// năm nào
    private Month month;//tháng nào
    private int day;//ngày nào
    private int orderCount;//Số lượng order trong thời gian này
    private OrderSimpleStatus orderStatus;//trạng thái order cần sinh
}
