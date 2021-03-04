package com.atguigu.gmall.oms.vo;

import com.atguigu.gmall.ums.entity.UserAddressEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/2/27 22:52
 * className : OrderSubmitVo
 * package: com.atguigu.gmallorder.pojo
 * version : 1.0
 * Description
 */
@Data
public class OrderSubmitVo {

    // 防重
    private String orderToken;
    // 收货地址
    private UserAddressEntity address;

    private Integer payType;

    private String deliveryCompany;

    private Integer bounds;

    private List<OrderItemVo> items;
    // 验总价
    private BigDecimal totalPrice;

}
