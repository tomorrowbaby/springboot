package com.example.demo.respository;

import com.example.demo.po.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    List<UserRole> findByUserId(String userId) ;
}
