package com.lqq.mapper;

import com.lqq.model.Article;
import com.lqq.model.User;
import com.lqq.model.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Reader;
import java.util.List;

public class UserMapperTest {

    /*private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("config/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    private static ApplicationContext ctx;

    static {
        ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    }

    @Test
    public void testGetUserById() throws Exception {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");


//        User user = sqlSession.selectOne("com.lqq.mapper.UserMapper.getUserById", 1);

        User user = userMapper.getUserById(1);
        System.out.println(user.getId());
        System.out.println(user.getUserName());
        System.out.println(user.getUserAddress());
        System.out.println(user.getUserAge());

    }

    @Test
    public void testGetAllUsers() throws Exception {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        List<User> users = userMapper.getAllUsers();
        for (User user : users) {
            System.out.println("===================================");
            System.out.print(user.getId() + " || ");
            System.out.print(user.getUserName() + " || ");
            System.out.print(user.getUserAddress() + " || ");
            System.out.println(user.getUserAge());
        }
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setId(2);
        user.setUserName("lisi");
        user.setUserAge(23);
        user.setUserAddress("上海市海沧区");

        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");

        userMapper.addUser(user);

    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(2);
        user.setUserName("wangwu");
        user.setUserAge(343);
        user.setUserAddress("上海市海沧区");
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUserById() throws Exception {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        userMapper.deleteUserById(2);
    }

    @Test
    public void testGetUserByName() throws Exception {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        List<User> users = userMapper.getUserByName("%z%");
        for (User user : users) {
            System.out.println("===================================");
            System.out.print(user.getId() + " || ");
            System.out.print(user.getUserName() + " || ");
            System.out.print(user.getUserAddress() + " || ");
            System.out.println(user.getUserAge());
        }
    }

    @Test
    public void testGetUserArticles() throws Exception {
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        List<Article> articles = userMapper.getUserArticles(1);
        System.out.println(articles.toString());
    }

    @Test
    public void testSelectByExample() {
        UserExample userExample = new UserExample();
        userExample.setUserName("liuqq");

        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users.size());
        for (User user : users) {
            this.printUserInfo(user);
        }
    }

    private void printUserInfo(User user) {
        System.out.println("===================================");
        System.out.print(user.getId() + " || ");
        System.out.print(user.getUserName() + " || ");
        System.out.print(user.getUserAddress() + " || ");
        System.out.println(user.getUserAge());



    }
    @Test
    public void testGetUserByUserAge(){
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        User user =  userMapper.getUserByUserAge(29);
        printUserInfo(user);
    }

}