package com.atguigu.gmall.wms.vo;

import lombok.Data;

/**
 * @author : SongMc
 * @date : 2021/2/28 9:00
 * className : SkuLockVo
 * package: com.atguigu.gmall.wms.vo
 * version : 1.0
 * Description
 */
@Data
public class SkuLockVo {

    private Long skuId;
    private Integer count;
    // 锁定仓库的id
    private Long wareSkuId;
    // 锁定状态
    private Boolean lock;

}
