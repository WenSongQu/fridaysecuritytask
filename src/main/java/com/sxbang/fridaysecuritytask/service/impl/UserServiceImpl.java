package com.sxbang.fridaysecuritytask.service.impl;

import com.sxbang.fridaysecuritytask.dao.UserDAO;
import com.sxbang.fridaysecuritytask.model.Users;
import com.sxbang.fridaysecuritytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Users selectUserByUserName(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        List<Users> list = userDAO.findAll(Example.of(user));
        return list.isEmpty() ? null : list.get(0);
    }
}
