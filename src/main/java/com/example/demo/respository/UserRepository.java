package com.example.demo.respository;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 描述：用户Repository
 * @author 王玉
 * @date 2019/2/28
 */
public interface UserRepository extends JpaRepository<User,String> {



}
