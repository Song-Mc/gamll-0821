package com.atguigu.gmall.search.feign;

import com.atguigu.gmall.pms.api.GmallPmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : SongMc
 * @date : 2021/1/28 22:16
 * className : GmallPmsClient
 * package: com.atguigu.gmall.search.feign
 * version : 1.0
 * Description
 */
@FeignClient("pms-service")
public interface GmallPmsClient extends GmallPmsApi {


}
