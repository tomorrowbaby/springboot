package com.example.demo.service;

import com.example.demo.po.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



/**
 * 描述:用户Service
 * @author 王玉
 * @date 2019/2/25
 */
public interface UserService {

    /**
     * 描述:由名字和密码查询
     * @param name
     * @param password
     * @return
     */
    public User findByNameAndPassword(String name , String password);

    /**
     * 描述:查找单个数据
     * @param id
     * @return
     */
    User findById(String id) ;

    /**
     * 描述 :查找所有信息
     * @return
     */
    List<User> findAll() ;

    /**
     * 描述: 保存和更新信息
     * @param user
     * @return
     */
    User save(User user) ;

    /**
     * 描述: 删除数据
     * @param id
     */
    void delete(String id) ;

    /**
     * 描述:分页查询
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable) ;

    /**
     * 描述：通过姓名查询
     * @param userName
     * @return
     */
    User findByUserName(String userName) ;

    /**
     * 描述：查找-重连
     * @param name
     * @param password
     * @return
     */
    User findByNameAndPasswordRetry(String name ,String password) ;


}
