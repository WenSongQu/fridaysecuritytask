package com.sxbang.fridaysecuritytask.config.security.jwt;

import com.sun.deploy.net.HttpResponse;
import com.sxbang.fridaysecuritytask.common.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class JwtLoginController {

    @Autowired
    JwtAuthService jwtAuthService;

    /**
     * 登录方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @PostMapping({"/login", "/"})
    public RestResult login(String username, String password, HttpServletResponse httpServletResponse , HttpServletRequest httpServletRequest) {
        RestResult result = RestResult.success();
        String token = jwtAuthService.login(username, password);
        result.put("token", token);
        httpServletResponse.setHeader("Authorization",token);
        Cookie cookie = new Cookie("Authorization",token);
        httpServletResponse.addCookie(cookie);
        System.out.println(httpServletResponse+"----------");
        return result;
    }
}
