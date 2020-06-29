package com.sxbang.fridaysecuritytask.service;

import com.sxbang.fridaysecuritytask.model.Users;

public interface UserService {
    public Users selectUserByUserName(String userName);
}
