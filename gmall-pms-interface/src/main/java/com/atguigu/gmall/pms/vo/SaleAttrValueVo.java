package com.atguigu.gmall.pms.vo;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author : SongMc
 * @date : 2021/2/19 16:34
 * className : SaleAttrValueVo
 * package: com.atguigu.gmall.item.vo
 * version : 1.0
 * Description
 */
@Data
public class SaleAttrValueVo {

    private Long attrId;
    private String attrName;
    private Set<String> attrValues;

}
