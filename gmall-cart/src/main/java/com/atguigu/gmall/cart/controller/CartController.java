package com.atguigu.gmall.cart.controller;

import com.atguigu.gmall.cart.interceptor.LoginInterceptor;
import com.atguigu.gmall.cart.pojo.Cart;
import com.atguigu.gmall.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author : SongMc
 * @date : 2021/2/23 20:26
 * className : CartController
 * package: com.atguigu.gmall.cart.controller
 * version : 1.0
 * Description
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String saveCart(Cart cart) {

        this.cartService.saveCart(cart);

        return "redirect:http://cart.gmall.com/addCart.html?skuId=" + cart.getSkuId();
    }

    @GetMapping("addCart.html")
    public String toCart(@RequestParam("skuId")Long skuId, Model model){

        Cart cart = this.cartService.queryCartBySkuId(skuId);
        model.addAttribute("cart",cart);
        return "addCart";
    }


    @RequestMapping("test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        long now = System.currentTimeMillis();
        this.cartService.executor1();
        this.cartService.executor2();
//        future1.addCallback(result -> {
//            System.out.println(result);
//        },ex -> {
//            System.out.println(ex.getMessage());
//        });
//        future2.addCallback(result -> {
//            System.out.println(result);
//        },ex -> {
//            System.out.println(ex.getMessage());
//        });
//        try {
//            System.out.println(future1.get());
//            System.out.println(future2.get());
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage() + "==================");
//        }
        System.out.println("controller方法的执行时间：" + (System.currentTimeMillis() - now));
        return "hello Test";
    }
}
