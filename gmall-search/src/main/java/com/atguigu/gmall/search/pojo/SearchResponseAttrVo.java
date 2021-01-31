package com.atguigu.gmall.search.pojo;

import com.atguigu.gmall.pms.entity.BrandEntity;
import lombok.Data;

import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/1/31 15:14
 * className : SearchResponseAttrVo
 * package: com.atguigu.gmall.search.pojo
 * version : 1.0
 * Description
 */
@Data
public class SearchResponseAttrVo {

    private Long attrId;

    private String attrName;

    // 规格参数的可选值列表
    private List<String> attrValue;

}
