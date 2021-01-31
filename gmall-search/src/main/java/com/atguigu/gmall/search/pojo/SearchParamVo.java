package com.atguigu.gmall.search.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/1/29 20:04
 * className : SearchParamVo
 * package: com.atguigu.gmall.search.pojo
 * version : 1.0
 * Description  s
 * search.gmall.com/search?keywork=手机&brandId=1,2,3&categoryId=225&props=4:8G-12G
 *  &props=5:128G-256G-512G&sort=1&priceFrom=1000&priceTo=2000&store=true&pageNum=1
 */
@Data
public class SearchParamVo {

    // 检索关键字
    private String keyword;

    // 品牌的过滤条件
    private List<Long> brandId;

    // 分类的过滤条件
    private List<Long> categoryId;

    // 规格参数的过滤：["4:8G-12G","5:128G-256G"]
    private List<String> props;

    // 排序字段： 0-默认，根据得分降序排列，1-价格降序，2-价格升序，3-销量降序，4-新品降序
    private Integer sort;

    // 价格区间过滤
    private Double priceFrom;
    private Double prictTo;

    // 是否有货的过滤
    private Boolean store;

    // 分页参数
    private Integer pageNum = 1;
    private final Integer pageSize = 20;


}
