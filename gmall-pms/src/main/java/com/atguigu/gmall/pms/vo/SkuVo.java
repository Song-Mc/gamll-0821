package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SkuAttrValueEntity;
import com.atguigu.gmall.pms.entity.SkuEntity;
import io.swagger.models.auth.In;
import lombok.Data;
import org.bouncycastle.pqc.math.linearalgebra.BigEndianConversions;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/1/20 19:49
 * className : SkuVo
 * package: com.atguigu.gmall.pms.vo
 * version : 1.0
 * Description
 */
@Data
public class SkuVo extends SkuEntity {

    // sku的图片列表
    private List<String> images;

    // 销售属性
    private List<SkuAttrValueEntity> saleAttrs;

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
