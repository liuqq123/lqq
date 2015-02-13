package com.lqq.mapper;

import com.lqq.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liuqq
 * Date: 2015/2/13
 * Time: 16:20
 */
public class UserMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        /*User user = sqlSession.selectOne("com.lqq.mapper.UserMapper.selectUserByID", 1);
        System.out.println("user.getUserName() = " + user.getUserName());

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user2 = userMapper.getUserById(1);
        System.out.println("user2.getUserName() = " + user2.getUserName());*/

        User user = new User();
        user.setId(2);
        user.setUserName("lqq");
        user.setUserAddress("lqq");
        user.setUserAge(11);
        userMapper.addUser(user);
        sqlSession.commit();


        List<User> users = userMapper.getAllUsers();
        System.out.println("users = " + users.size());
        sqlSession.close();
    }
}
