package com.atguigu.gmall.oms.mapper;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单
 * 
 * @author SongMc
 * @email SongMc@163.com
 * @date 2021-02-28 13:57:42
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

    int updateStatus(@Param("orderToken") String orderToken,@Param("expectStatus")Integer expectStatus,@Param("targetStatus")Integer targetStatus);
	
}
