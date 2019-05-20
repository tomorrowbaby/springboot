package com.example.demo.respository;

import com.example.demo.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：用户身份Repository
 * @author wangyu
 * @date 2019/5/19
 */


public interface RoleRepository extends JpaRepository<Role,String> {
}
