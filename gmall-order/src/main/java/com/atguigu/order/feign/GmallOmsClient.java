package com.atguigu.order.feign;

import com.atguigu.gmall.oms.api.GmallOmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : SongMc
 * @date : 2021/3/2 8:38
 * className : GmallOmsClient
 * package: com.atguigu.gmallorder.feign
 * version : 1.0
 * Description
 */
@FeignClient("oms-service")
public interface GmallOmsClient extends GmallOmsApi {
}
