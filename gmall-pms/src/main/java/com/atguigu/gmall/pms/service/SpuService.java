package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.vo.SpuVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SpuEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author SongMc
 * @email SongMc@163.com
 * @date 2021-01-18 20:10:16
 */
public interface SpuService extends IService<SpuEntity> {

    PageResultVo queryPage(PageParamVo pageParamVo);

    PageResultVo querySpuByCidAndPage(PageParamVo pageParamVo, Long cid);

    void bigSave(SpuVo spu);


}

