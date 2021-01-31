package com.atguigu.gmall.pms.vo;

import com.atguigu.gmall.pms.entity.SpuEntity;
import lombok.Data;

import java.util.List;

/**
 * @author : SongMc
 * @date : 2021/1/20 19:41
 * className : SpuVo
 * package: com.atguigu.gmall.pms.vo
 * version : 1.0
 * Description
 */
@Data
public class SpuVo extends SpuEntity {

    private List<String> spuImages;

    private List<SpuAttrValueVo> baseAttrs;

    private List<SkuVo> skus;


}
