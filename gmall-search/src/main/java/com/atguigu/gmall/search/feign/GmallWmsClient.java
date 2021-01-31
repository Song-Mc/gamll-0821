package com.atguigu.gmall.search.feign;

import com.atguigu.gmall.wms.api.GmallWmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : SongMc
 * @date : 2021/1/28 22:16
 * className : GmallWmsClient
 * package: com.atguigu.gmall.search.feign
 * version : 1.0
 * Description
 */
@FeignClient("wms-service")
public interface GmallWmsClient extends GmallWmsApi {
}
