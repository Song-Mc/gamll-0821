package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品三级分类
 * 
 * @author SongMc
 * @email SongMc@163.com
 * @date 2021-01-18 20:10:16
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    List<CategoryEntity> queryLvl2CatesWithSubsByPid(Long pid);
}
