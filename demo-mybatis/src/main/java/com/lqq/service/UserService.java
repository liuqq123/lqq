package com.lqq.service;

import com.lqq.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuqq
 * Date: 2015/2/13
 * Time: 17:31
 */
public interface UserService {

    public User getUserById(int id);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public Integer deleteUserById(int id);
}
