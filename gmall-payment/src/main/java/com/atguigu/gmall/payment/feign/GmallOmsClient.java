package com.atguigu.gmall.payment.feign;

import com.atguigu.gmall.oms.api.GmallOmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SongMc
 * @date 2021/3/4 15:20
 * @InterfaceName GmallOmsClient
 * version : 1.0
 * Description
 **/
@FeignClient("oms-service")
public interface GmallOmsClient extends GmallOmsApi {
}
