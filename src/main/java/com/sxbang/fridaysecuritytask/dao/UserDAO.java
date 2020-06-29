package com.sxbang.fridaysecuritytask.dao;

import com.sxbang.fridaysecuritytask.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<Users, Long> {
}
