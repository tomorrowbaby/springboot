package com.example.demo.po;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：QQ空间说说
 * @author wangyu
 * @date 2019/5/16
 */

public class Talk implements Serializable {
    //主键
    @Id
    private String id ;
    //说说内容
    private String content ;
    //用户Id
    private String userId ;
    //点赞数量
    private Integer praiseNum ;
    //发表时间
    private Date publishTime ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Talk{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", praiseNum=" + praiseNum +
                ", publishTime=" + publishTime +
                '}';
    }
}
