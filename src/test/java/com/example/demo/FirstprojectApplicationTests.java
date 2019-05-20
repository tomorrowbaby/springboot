package com.example.demo;

import com.example.demo.activemq.Producer;
import com.example.demo.async.Async;
import com.example.demo.dao.UserDao;
import com.example.demo.mail.SendJunkMailService;
import com.example.demo.model.UserAttachementRel;
import com.example.demo.po.User ;
import com.example.demo.service.UserAttachementReqService;
import com.example.demo.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import javax.jms.Destination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstprojectApplicationTests {
	@Resource
	private UserService userService ;
	@Resource
	private JdbcTemplate jdbcTemplate ;
	@Resource
	private RedisTemplate redisTemplate ;
	@Resource
	private StringRedisTemplate stringRedisTemplate ;
	@Resource
	SendJunkMailService sendJunkMailService ;
	@Resource
	Producer producer ;
	@Resource
	Async async ;
	@Resource
	UserAttachementReqService userAttachementReqService ;
	@Autowired
	UserDao userDao ;


	/**
	 * Mybatis集成测试
	 */
	@Test
	public void userTest(){
		User user = userDao.findByUserName("秋香");
		System.out.println(user);
	}


	/**
	 * Mysql集成Spring Boot简单测试
	 */

	@Test
	public void mySqlTest() {
		String sql = "select id,name,password from user_test";
		List<User> userList =
				(List<User>) jdbcTemplate.query(sql, new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = new User();
						user.setId(rs.getString("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
		System.out.println("查询成功：");
		for (User user : userList) {
			System.out.println("【id】: " + user.getId() + "；【name】: " + user.getName());
		}
	}


	/**
	 * ＪＰＡ　继承测试
	 */
	@Test
	public void jpaTest(){
		//查询所有数据
		List<User> userList = userService.findAll() ;
		System.out.println("findAll() :"+userList);


		//根据Ｉｄ查询3
		User user = userService.findById("1") ;
		System.out.println("findById() :"+user);

		//保存信息
		User insertUser = new User() ;
		insertUser.setId("2");
		insertUser.setName("秋香");
		insertUser.setPassword("123456");
		User user2  = userService.save(insertUser) ;
		System.out.println(user2);

		//删除信息
		// userService.delete("2");

		//分页查询
		Pageable pageable = new PageRequest(0,10);
		Page<User> userList2 = userService.findAll(pageable) ;
		System.out.println("page findALL() :" +userList2.getSize());

	}

	/**
	 * 事物测试
	 */
	@Test
	public void testTransaction(){
		//保存信息
		User insertUser = new User() ;
		insertUser.setId("3");
		insertUser.setName("隔壁老王");
		insertUser.setPassword("123456");
		User user2  = userService.save(insertUser) ;
		System.out.println(user2);

	}

	/**
	 * Redis测试
	 */
	@Test
	public void testRedis(){
		//增加  key:name ,value:唐伯虎
		redisTemplate.opsForValue().set("name","唐伯虎");
		String name = (String) redisTemplate.opsForValue().get("name") ;
		System.out.println(name);

		//删除
		redisTemplate.delete("name") ;
		name = (String) redisTemplate.opsForValue().get("name") ;
		System.out.println(name);
		//更新
		redisTemplate.opsForValue().set("name","秋香");

		//查询
		name = (String) redisTemplate.opsForValue().get("name") ;
		System.out.println(name);
	}

	/**
	 * Redis测试2
	 */
	@Test
	public void testRedis2(){
		User user =  userService.findById("1") ;
		System.out.println(user);
		System.out.println("当前缓存的数量 :" + redisTemplate.opsForList().size("ALL_USER_LIST"));

		user = userService.findById("5");
		System.out.println(user);
		System.out.println("当前缓存的数量 :" + redisTemplate.opsForList().size("ALL_USER_LIST"));

	}


	/**
	 * 描述：Email发送测试
	 */
	@Test
	public void testEmail() {
		sendJunkMailService.sendJunKMail() ;
	}

	/**
	 * 描述：ActiveMQ 测试
	 */
	@Test
	public void testActiveMQ() {
		Destination destination = new ActiveMQQueue("activemq.queue") ;
		producer.sendMessage(destination,"ActiveMQ测试消息");
	}


	/**
	 * 描述：Async测试-普通方法运行时间
	 */
	@Test
	public void testNormal() {
		long startTime = System.currentTimeMillis() ;
		System.out.println("第一次执行任务---");
		async.task() ;
		System.out.println("第二次执行任务---");
		async.task() ;
		System.out.println("第三次执行任务---");
		async.task() ;
		long endTime = System.currentTimeMillis() ;
		long time = endTime - startTime ;
		System.out.println("普通方法花费时间："+time);
	}

	/**
	 * 描述： Async测试 - Async方法运行时间
	 * @throws Exception
	 */
	@Test
	public void testAsync() throws Exception {
		long startTime = System.currentTimeMillis() ;
		System.out.println("第一次执行任务---");
		async.taskAsync();
		System.out.println("第二次执行任务---");
		async.taskAsync();
		System.out.println("第三次执行任务---");
		async.taskAsync();
		while (true){
			if (async.flag == 3) break;
			else Thread.sleep(3);
		}
		long endTime = System.currentTimeMillis() ;
		long time = endTime - startTime ;
		System.out.println("Async方法花费总时间时间："+time);
	}

	/**
	 * MongoDB测试
	 */
	@Test
	public void testMongoDB() {
		UserAttachementRel userAttachementRel= new UserAttachementRel() ;
		userAttachementRel.setId("1");
		userAttachementRel.setUserId("1");
		userAttachementRel.setFileName("个人简历.doc");
		userAttachementReqService.save(userAttachementRel) ;
		System.out.println("保存成功");

	}

}
