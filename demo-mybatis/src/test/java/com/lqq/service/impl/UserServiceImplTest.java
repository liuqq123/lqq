package com.lqq.service.impl;

import com.lqq.model.User;
import com.lqq.service.UserService;
import org.junit.Test;

public class UserServiceImplTest {

    @Test
    public void testGetUserById() throws Exception {
        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(1);
        System.out.println("user = " + user.getUserName());
    }

    @Test
    public void testGetAllUsers() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUserById() throws Exception {

    }
}