package com.lqq.mapper;

import com.lqq.model.Article;
import com.lqq.model.User;
import com.lqq.model.UserExample;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuqq
 * Date: 2015/2/13
 * Time: 16:24
 */
public interface UserMapper {
    public User getUserById(int id);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateUser(User user);

    public Integer deleteUserById(int id);


    public List<User> getUserByName(String userName);

    public List<Article> getUserArticles(int id);

    public List<User> selectByExample(UserExample userExample);

    @Select("select * from user where userAge=#{userAge}")
    public User getUserByUserAge(int userAge);
}
