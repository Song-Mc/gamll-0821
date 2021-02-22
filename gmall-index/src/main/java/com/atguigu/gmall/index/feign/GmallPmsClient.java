package com.atguigu.gmall.index.feign;

import com.atguigu.gmall.pms.api.GmallPmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SongMc
 * @date 2021/2/3 11:50
 * @InterfaceName GmallPmsClient
 * version : 1.0
 * Description
 **/
@FeignClient("pms-service")
public interface GmallPmsClient extends GmallPmsApi {
}
