package com.example.demo.service;


import com.example.demo.po.UserRole;

import java.util.List;

/**
 * 描述：用户-身份 关联Service层
 * @author wangyu
 * @date 2019/5/19
 */

public interface UserRoleService {

    List<UserRole> findByUserId(String userId) ;

}
