package com.example.demo.serviceimpl;

import com.example.demo.dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.respository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:用户service实现类
 * @author 王玉
 * @date 2019/2/25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource(name="userRepository")
    private UserRepository userRepository ;

    @Resource
    private RedisTemplate redisTemplate ;

    public static final String ALL_USER = "ALL_USER_LIST" ;
    /**
     * 描述:由名字和密码查询
     * @param name
     * @param password
     * @return
     */
    @Override
    public User findByNameAndPassword(String name , String password){
        return userDao.findByNameAndPassword(name,password) ;
    }


    /**
     * 描述:查找单个数据
     * @param id
     * @return User
     */
    @Override
    public User findById(String id) {
        //先查询Redis中的所有值
        List<User> userList = redisTemplate.opsForList().range(ALL_USER,0,-1) ;
        if ( !userList.equals(null) && userList.size() > 0){
            for (User user : userList){
                if (user.getId().equals(id)) return user ;
            }
        }
        System.out.println("从数据库查询");
        //redis为空查询数据库
        User user = userRepository.getOne(id) ;
        System.out.println(user);
        if ( !user.equals(null))

            //插入Redis数据
            redisTemplate.opsForList().leftPush(ALL_USER,user) ;
        return user ;
    }

    /**
     * 描述 :查找所有信息
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll() ;
    }

    /**
     * 描述: 保存和更新信息
     * @param user
     * @return User
     */
    @Override
    public User save(User user) {
        User user1 = userRepository.save(user) ;
        return user1 ;
    }

    /**
     * 描述: 删除数据
     * @param id
     */
    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    /**
     * 描述:分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    /**
     * 描述:通过姓名查找
     * @param name
     * @return
     */
    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }
}
