package com.atguigu.gmall.pms.vo;

import lombok.Data;

import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/2/19 17:50
 * className : ItemGroupVo
 * package: com.atguigu.gmall.item.vo
 * version : 1.0
 * Description
 */
@Data
public class ItemGroupVo {

    private Long id;
    private String name;
    private List<AttrValueVo> attrValue;

}
