package com.example.demo.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述：用户-身份关联实体类
 * @author wangyu
 * @date 2019/5/19
 */

@Entity
@Table(name = "user_role_test")
public class UserRole {

    @Id
    private String id ;
    private String userId ;
    private String roleId ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
