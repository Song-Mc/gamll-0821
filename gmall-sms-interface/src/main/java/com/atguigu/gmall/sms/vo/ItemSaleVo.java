package com.atguigu.gmall.sms.vo;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author : SongMc
 * @date : 2021/2/19 16:29
 * className : ItemSaleVo
 * package: com.atguigu.gmall.item.vo
 * version : 1.0
 * Description
 */
@Data
public class ItemSaleVo {

    // 营销类型
    private String type;
    // 营销的描述信息
    private String desc;


}
