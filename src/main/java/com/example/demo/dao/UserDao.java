package com.example.demo.dao;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 描述:用户Dao
 * @author 王玉
 * @date 2019/9/24
 */
@Mapper
public interface UserDao {
    /**
     * 描述:通过用户名和密码查询用户
     * @param name
     * @param password
     * @return User
     */
    // @Select("SELECT * FROM user_test WHERE user_name = #{name}")
     public User findByNameAndPassword(@Param("name") String name, @Param("password") String password) ;
}
