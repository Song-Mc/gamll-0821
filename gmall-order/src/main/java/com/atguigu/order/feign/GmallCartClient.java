package com.atguigu.order.feign;

import com.atguigu.gmall.cart.api.GmallCartApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : SongMc
 * @date : 2021/2/27 20:42
 * className : GmallCartClient
 * package: com.atguigu.gmallorder.feign
 * version : 1.0
 * Description
 */
@FeignClient("cart-service")
public interface GmallCartClient extends GmallCartApi {
}
