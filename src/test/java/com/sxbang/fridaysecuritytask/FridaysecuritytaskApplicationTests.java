package com.sxbang.fridaysecuritytask;

import com.sxbang.fridaysecuritytask.config.security.jwt.jwtTokenUtil;
import com.sxbang.fridaysecuritytask.model.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FridaysecuritytaskApplicationTests {
    @Autowired
    com.sxbang.fridaysecuritytask.config.security.jwt.jwtTokenUtil jwtTokenUtil;

    @Test
    void contextLoads() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("1234");
//        System.out.println(encode);
        Users users=new Users();
        users.setUserName("qws");
        users.setPassword("123456");

        String s = jwtTokenUtil.generateToken(users);
        System.out.println(s);
        String usernameFromToken = jwtTokenUtil.getUsernameFromToken("eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1OTMzOTYxMDUsInN1YiI6InF3cyIsImNyZWF0ZWQiOjE1OTMzOTI1MDUwNjB9.mBzKdsHzenAksTZq-BHlhk1SJinoM96_iYtvyAjAtKtrkhm6DArmYPa44Ol6L1e2l3b4QsvSNmxsVZ7VFp5HPg");
        System.out.println(usernameFromToken);
    }

}
