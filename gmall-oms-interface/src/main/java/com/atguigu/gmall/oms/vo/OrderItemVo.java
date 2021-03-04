package com.atguigu.gmall.oms.vo;

import com.atguigu.gmall.pms.entity.SkuAttrValueEntity;
import com.atguigu.gmall.sms.vo.ItemSaleVo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/2/26 22:16
 * className : OrderItemVo
 * package: com.atguigu.gmallorder.pojo
 * version : 1.0
 * Description
 */
@Data
public class OrderItemVo {

    private Long skuId;
    private String defaultImage;
    private String title;
    // 销售属性
    private List<SkuAttrValueEntity> saleAttrs;
    // 加入购物车时的价格
    private BigDecimal price;
    private BigDecimal count;
    // 是否有货
    private Boolean store = false;
    // 营销信息
    private List<ItemSaleVo> sales;
    // 商品重量
    private Integer weight;

}
