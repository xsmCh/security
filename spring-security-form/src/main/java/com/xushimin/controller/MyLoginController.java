package com.xushimin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyLoginController {
    /**
     * 失败页面
     * 1）这是后端响应，重定向到的页面
     * 2）在前后端分离时代，其实更适合用一个失败处理器返回JSON字符串
     *
     * @return 登录失败页面
     */
    @RequestMapping("/mylogin.html")
    public String mylogin() {
        return "mylogin";
    }
}
