package com.backend.devops.service;



import com.backend.devops.model.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryUserService implements AuthService {
    private final ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();

    @Override
    public boolean register(User user) {
        if (users.containsKey(user.getUsername())) {
            return false; // User already exists
        }
        users.put(user.getUsername(), user.getPassword());
        return true;
    }

    @Override
    public boolean login(String username, String password) {
        return password.equals(users.get(username));
    }
}
