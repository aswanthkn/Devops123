package com.backend.devops.service;


import com.backend.devops.model.User;

public interface AuthService {
    boolean register(User user);
    boolean login(String username, String password);
}
