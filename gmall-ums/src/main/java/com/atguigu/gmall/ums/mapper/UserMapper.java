package com.atguigu.gmall.ums.mapper;

import com.atguigu.gmall.ums.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author SongMc
 * @email SongMc@163.com
 * @date 2021-02-21 18:04:00
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
	
}
