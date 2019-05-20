package com.example.demo.serviceimpl;

import com.example.demo.po.UserRole;
import com.example.demo.respository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：用户-身份 关联Service层实现类
 * @author wangyu
 * @date 2019/5/19
 */

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    UserRoleRepository userRoleRepository ;

    @Override
    public List<UserRole> findByUserId(String userId) {
        return userRoleRepository.findByUserId(userId);
    }
}
