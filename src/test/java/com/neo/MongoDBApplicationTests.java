package com.neo;

import com.neo.model.User;
import com.neo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBApplicationTests {

	@Resource(name = "mySQLImpl")
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		System.out.println("hello world");
	}

	// 1
	@Test
	public void testMySQLJDBCTemplate() {
		User userByUserName = userRepository.findUserByUserName("lzx");
		System.out.println(userByUserName);
	}

	// 2
	@Test
	public void testMySQLMybatis() {
		User userByUserName = userRepository.findUserByUserNameMyBatis("lzx");
		System.out.println(userByUserName);
	}

}
