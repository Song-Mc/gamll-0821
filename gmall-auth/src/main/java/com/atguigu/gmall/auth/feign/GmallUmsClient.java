package com.atguigu.gmall.auth.feign;

import com.atguigu.gmall.ums.api.GmallUmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SongMc
 * @date 2021/2/22 19:10
 * @InterfaceName GmallUmsClient
 * version : 1.0
 * Description
 **/
@FeignClient("ums-service")
public interface GmallUmsClient extends GmallUmsApi {
}
