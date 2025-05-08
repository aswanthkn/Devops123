package com.backend.devops.service;


import com.backend.devops.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserServiceTest {

    private InMemoryUserService service;

    @BeforeEach
    void setUp() {
        service = new InMemoryUserService();
    }

    @Test
    void testRegisterNewUser() {
        boolean result = service.register(new User("test", "pass"));
        assertTrue(result);
    }

    @Test
    void testRegisterDuplicateUser() {
        service.register(new User("test", "pass"));
        boolean result = service.register(new User("test", "pass2"));
        assertFalse(result);
    }

    @Test
    void testLoginSuccess() {
        service.register(new User("test", "pass"));
        assertTrue(service.login("test", "pass"));
    }

    @Test
    void testLoginFailureWrongPassword() {
        service.register(new User("test", "pass"));
        assertFalse(service.login("test", "wrongpass"));
    }

    @Test
    void testLoginFailureUnknownUser() {
        assertFalse(service.login("unknown", "pass"));
    }
}
