package com.atguigu.gmall.pms.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : SongMc
 * @date : 2021/2/19 20:58
 * className : SkuAttrValueMapperTest
 * package: com.atguigu.gmall.pms.mapper
 * version : 1.0
 * Description
 */
@SpringBootTest
class SkuAttrValueMapperTest {

    @Autowired
    private SkuAttrValueMapper attrValueMapper;

    @Test
    void querySaleAttrsMappingSkuId() {
        System.out.println(this.attrValueMapper.querySaleAttrsMappingSkuId(Arrays.asList(25l,26l)));
    }
}