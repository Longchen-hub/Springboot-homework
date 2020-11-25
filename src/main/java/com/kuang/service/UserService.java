package com.kuang.service;

import com.kuang.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User queryUserById(String uid);
}
