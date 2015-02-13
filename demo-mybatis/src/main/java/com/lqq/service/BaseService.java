package com.lqq.service;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: liuqq
 * Date: 2015/2/13
 * Time: 17:32
 */
public interface BaseService {

    public SqlSessionFactory getSession();
}
