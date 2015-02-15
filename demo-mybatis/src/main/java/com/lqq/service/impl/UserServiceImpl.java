package com.lqq.service.impl;

import com.lqq.mapper.UserMapper;
import com.lqq.model.User;
import com.lqq.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuqq
 * Date: 2015/2/13
 * Time: 17:18
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {


    @Override
    public User getUserById(int id) {
        SqlSession sqlSession = super.getSession().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        SqlSession sqlSession = super.getSession().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = super.getSession().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.addUser(user);
        sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = super.getSession().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(user);
        sqlSession.commit();
    }

    @Override
    public Integer deleteUserById(int id) {
        SqlSession sqlSession = super.getSession().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(id);
        sqlSession.commit();
        return 0;
    }
}
