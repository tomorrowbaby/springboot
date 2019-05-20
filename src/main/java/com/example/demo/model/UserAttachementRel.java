package com.example.demo.model;

import org.springframework.data.annotation.Id;

/**
 * 描述：用户附件
 * @author wangyu
 * @date 2019/5/18
 */


public class UserAttachementRel {

    @Id
    private String id ;
    private String userId ;
    private String fileName ;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
