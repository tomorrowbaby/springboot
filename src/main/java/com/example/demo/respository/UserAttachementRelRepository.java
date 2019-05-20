package com.example.demo.respository;

import com.example.demo.model.UserAttachementRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述：用户附件类
 * @author wangyu
 * @date 2019/5/18
 */

public interface UserAttachementRelRepository
        extends MongoRepository<UserAttachementRel,String> {

}
