package com.example.demo.listener;

/**
 * 监听器
 * @author 王玉
 * @date 2019/3/10
 */

import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class UserListener implements ServletContextListener {
    @Resource
    private RedisTemplate redisTemplate ;
    @Resource
    private UserService userService ;

    public static final String ALL_USER = "ALL_USER_LIST" ;

    Logger logger = LogManager.getLogger(this.getClass()) ;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
       // System.out.println("ServletContext初始化");
        logger.info("初始化ServletContext");
        /*
        //查询数据库所有用户
        List<User> userList = userService.findAll() ;
        //清除缓存中的数据
        redisTemplate.delete(ALL_USER) ;
        //将数据放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER,userList) ;
        //查询所有的用户
        List<User> userList1 = redisTemplate.opsForList().range(ALL_USER,0,-1) ;
        //查看数据
        System.out.println("缓存中数据量 :" +userList1.size());
        */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("ServletContext销毁");
       // System.out.println("ServletContext销毁");
    }

}
