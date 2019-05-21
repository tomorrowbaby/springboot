package com.example.demo.actuator;




import com.example.demo.po.User;
import com.example.demo.service.UserService;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：自定义端点
 * @author  wangyu
 * @date    2019/5/20
 */

@Endpoint(id = "userEndPoint")
@Component
public class  UserEndPoint{

    @Resource
    UserService userService ;

    @ReadOperation
    public Map<String,Object> userEndPoint(@Selector String name){
        User user = userService.findByUserName(name) ;
        Map<String,Object> map = new HashMap<>() ;
        map.put("用户",user) ;
        map.put("当前时间",new Date()) ;
        return map ;
    }


}
