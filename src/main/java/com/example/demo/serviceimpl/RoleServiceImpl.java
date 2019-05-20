package com.example.demo.serviceimpl;

import com.example.demo.po.Role;
import com.example.demo.respository.RoleRepository;
import com.example.demo.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 描述：用户身份Service层实现类
 * @author wangyu
 * @date 2019/5/19
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository ;

    @Override
    public Role find(String id) {
        return roleRepository.findById(id).get();
    }
}
