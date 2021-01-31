package com.atguigu.gmall.pms.feign;

import com.atguigu.gmall.sms.api.GmallSmsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author SongMc
 * @date 2021/1/21 11:43
 * @InterfaceName GmallSmsClient
 * version : 1.0
 * Description
 **/
@FeignClient("sms-service")
public interface GmallSmsClient extends GmallSmsApi {


}
