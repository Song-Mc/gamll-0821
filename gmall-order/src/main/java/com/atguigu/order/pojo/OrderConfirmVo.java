package com.atguigu.order.pojo;

import com.atguigu.gmall.oms.vo.OrderItemVo;
import com.atguigu.gmall.ums.entity.UserAddressEntity;
import lombok.Data;

import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/2/26 22:13
 * className : OrderConfirmVo
 * package: com.atguigu.gmallorder.pojo
 * version : 1.0
 * Description
 */
@Data
public class OrderConfirmVo {

    // 收货人地址
    private List<UserAddressEntity> addresses;

    // 送货清单
    private List<OrderItemVo> orderItems;

    // 购物积分
    private Integer bounds;

    // 为了防止重复提交
    private String orderToken;

}
