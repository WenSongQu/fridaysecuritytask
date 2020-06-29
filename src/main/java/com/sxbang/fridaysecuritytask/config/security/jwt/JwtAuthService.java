package com.sxbang.fridaysecuritytask.config.security.jwt;

import com.sxbang.fridaysecuritytask.model.Users;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JwtAuthService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private jwtTokenUtil jwtTokenUtil;

    /**
     * 登录认证换取JWT令牌
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public String login(String username, String password)  {
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
                throw new RuntimeException("用户名密码错误");
        }
        Users loginUser = (Users) authentication.getPrincipal();
        System.out.println(loginUser.getRoles());
        loginUser.getAuthorities().forEach(System.out::println);
        // 生成token
        return jwtTokenUtil.generateToken(loginUser);
    }
}
