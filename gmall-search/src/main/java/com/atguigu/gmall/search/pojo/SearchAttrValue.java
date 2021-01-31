package com.atguigu.gmall.search.pojo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author : SongMc
 * @date : 2021/1/28 20:22
 * className : SearchAttrValue
 * package: com.atguigu.gmall.search.pojo
 * version : 1.0
 * Description
 */
@Data
public class SearchAttrValue {

    @Field(type = FieldType.Long)
    private Long attrId;
    @Field(type = FieldType.Keyword)
    private String attrName;
    @Field(type = FieldType.Keyword)
    private String attrValue;

}
