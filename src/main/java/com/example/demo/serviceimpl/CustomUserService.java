package com.example.demo.serviceimpl;

import com.example.demo.po.User;
import com.example.demo.po.UserRole;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：自定义用户服务类
 * @author wangyu
 * @date 2019/5/19
 */

public class CustomUserService implements UserDetailsService {
    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService ;

    @Resource
    private RoleService roleService ;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //1.利用Security框架接受到用户名
        //2.通过用户名查询到用户
        User user = userService.findByUserName(name) ;
        if (user == null){
            System.out.println("用户不存在");
        }

        //3.由用户的ID获取身份信息
        List<UserRole> userRoleList = userRoleService.findByUserId(user.getId()) ;
        //4.创建身份识别的列表
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>() ;
            if (userRoleList != null && userRoleList.size() > 0){
                for (UserRole role:
                     userRoleList) {
                    //5. 获得用户关联的身份名称
                    String roleName = roleService.find(role.getId()).getName();
                    //6. 将用户的身份信息添加到Security的用户身份认证列表
                    authorityList.add(new SimpleGrantedAuthority(roleName)) ;
                }
            }
        //7.返回一个用户的完整的认证信息：用户名，密码，身份信息
        System.out.println(authorityList.get(0).getAuthority().toString());
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),authorityList);
    }
}
