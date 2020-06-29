package com.sxbang.fridaysecuritytask.config.security.service;

import com.sxbang.fridaysecuritytask.model.Users;
import com.sxbang.fridaysecuritytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userService.selectUserByUserName(username);
        if (users == null){
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        //将数据库的roles解析为UserDetails的权限集
        //AuthorityUtils.commaSeparatedStringToAuthorityList将逗号分隔的字符集转成权限对象列表
        users.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(users.getRoles()));
        return users;
    }
}
