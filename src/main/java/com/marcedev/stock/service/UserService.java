package com.marcedev.stock.service;

import com.marcedev.stock.entity.User;

public interface UserService {
    User register(User user);
    User findByUsername(String username);
}
