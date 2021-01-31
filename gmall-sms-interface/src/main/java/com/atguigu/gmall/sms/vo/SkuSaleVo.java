package com.atguigu.gmall.sms.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/1/21 11:11
 * className : SkuSaleVo
 * package: com.atguigu.gmall.sms.vo
 * version : 1.0
 * Description
 */
@Data
public class SkuSaleVo {

    private Long skuId;

    // 积分优惠信息
    private BigDecimal growBounds;
    private BigDecimal buyBounds;
    private List<Integer> work;

    // 满减优惠信息
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private Integer fullAddOther;

    // 打折优惠信息
    private Integer fullCount;
    private BigDecimal discount;
    private Integer ladderAddOther;

}
