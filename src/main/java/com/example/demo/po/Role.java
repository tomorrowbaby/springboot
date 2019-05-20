package com.example.demo.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 描述：用户身份实体
 * @author wangyu
 * @date 2019/5/19
 */

@Entity
@Table(name = "role_test")
public class Role {

    @Id
    private String id ;
    private String name ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
