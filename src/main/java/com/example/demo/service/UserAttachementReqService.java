package com.example.demo.service;

import com.example.demo.model.UserAttachementRel;

/**
 * 描述：用户邮件服务层
 * @author wangyu
 * @date 2019/5/18
 */

public interface UserAttachementReqService {

    /**
     * 描述：保存用户邮件信息
     * @param userAttachementRel
     * @return
     */
    UserAttachementRel save(UserAttachementRel userAttachementRel) ;
}
