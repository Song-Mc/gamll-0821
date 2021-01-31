package com.atguigu.gmall.search.controller;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.search.pojo.SearchParamVo;
import com.atguigu.gmall.search.pojo.SearchResponseVo;
import com.atguigu.gmall.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : SongMc
 * @date : 2021/1/29 20:16
 * className : SearchController
 * package: com.atguigu.gmall.search.controller
 * version : 1.0
 * Description
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping
    @ResponseBody
    public ResponseVo<SearchResponseVo> search(SearchParamVo paramVo){

        SearchResponseVo responseVo = this.searchService.search(paramVo);
        return ResponseVo.ok(responseVo);

    }

}
