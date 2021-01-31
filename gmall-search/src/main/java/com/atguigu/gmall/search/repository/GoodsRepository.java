package com.atguigu.gmall.search.repository;

import com.atguigu.gmall.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : SongMc
 * @date : 2021/1/28 20:50
 * className : GoodsRepository
 * package: com.atguigu.gmall.search.repository
 * version : 1.0
 * Description
 */
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
