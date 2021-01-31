package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author SongMc
 * @email SongMc@163.com
 * @date 2021-01-18 20:10:16
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
	
}
