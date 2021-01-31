package com.atguigu.gmall.sms.api;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.sms.vo.SkuSaleVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : SongMc
 * @date : 2021/1/21 14:22
 * className : GmallSmsApi
 * package: com.atguigu.gmall.sms.api
 * version : 1.0
 * Description
 */
public interface GmallSmsApi {

    @PostMapping("sms/skubounds/save")
    public ResponseVo saveSales(@RequestBody SkuSaleVo saleVo);


}
