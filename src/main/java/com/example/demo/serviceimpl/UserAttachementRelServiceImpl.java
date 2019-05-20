package com.example.demo.serviceimpl;

import com.example.demo.model.UserAttachementRel;
import com.example.demo.respository.UserAttachementRelRepository;
import com.example.demo.service.UserAttachementReqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：用户附件实现层
 * @author wangyu
 * @date 2019/5/18
 */

@Service
public class UserAttachementRelServiceImpl implements UserAttachementReqService {

    @Resource
    private UserAttachementRelRepository userAttachementRelRepository ;

    @Override
    public UserAttachementRel save(UserAttachementRel userAttachementRel) {
        return userAttachementRelRepository.save(userAttachementRel) ;
    }
}
